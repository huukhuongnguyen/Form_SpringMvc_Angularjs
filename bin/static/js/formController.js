var app = angular.module('MainApp',[]);
app.controller('CustomerController', function($scope, $http){
	
	$scope.Customer={};
	$scope.customers = [];
	$scope.getCustomer = function() {

		var url = "/getCustomer";
		$http.get(url).then(function(response) {
			
			$scope.customers = response.data;
			
		});
	}	
	$scope.getCustomer();
	$scope.submitCustomer=function(){
		
		var url = "/submit";
		$http.post(url,$scope.Customer).then(function(reponse){
			return new Promise(function(resolve,reject){
				if(reponse.data==1){
					resolve($scope.getCustomer());
				};
			});
		});
		
	}
	
	$scope.editCustomer=function(customer){
		
		$scope.Customer.id=customer.id;
		$scope.Customer.name=customer.name;
		$scope.Customer.adress=customer.adress;
		$scope.Customer.phone=customer.phone;
		
	}

	$scope.clear=function(){
		$scope.Customer.id="";
		$scope.Customer.name="";
		$scope.Customer.adress="";
		$scope.Customer.phone="";
		
	}
	
	$scope.deleteCustomer=function(customer){
		
		var url ="/deleteCustomer/"+customer.id;
		$http.post(url).then(function(reponse){
			return new Promise(function(resolve,reject){
				if(reponse.data==1){
					resolve($scope.getCustomer());
				};
			});
			
		});
		
	}

});
	
