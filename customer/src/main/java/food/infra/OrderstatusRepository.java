package food.infra;

import food.domain.*;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(
    collectionResourceRel = "orderstatuses",
    path = "orderstatuses"
)
public interface OrderstatusRepository
    extends PagingAndSortingRepository<Orderstatus, Long> {
    List<Orderstatus> findByOrderid(String orderid);
}
