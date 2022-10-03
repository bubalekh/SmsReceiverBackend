package pw.cyberbrain.smsreceiverbackend.repository;

import org.springframework.data.repository.CrudRepository;
import pw.cyberbrain.smsreceiverbackend.domain.Template;

public interface TemplateRepository extends CrudRepository<Template, Integer> {
}
