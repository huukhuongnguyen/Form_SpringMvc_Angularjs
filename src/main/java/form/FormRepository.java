package form;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface FormRepository extends JpaRepository<Customer, Long> {
	public void deleteById(int id);
}
