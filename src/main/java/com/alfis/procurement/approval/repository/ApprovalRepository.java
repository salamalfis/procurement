package main.java.com.alfis.procurement.approval.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.alfis.procurement.approval.entity.Approval;

@Repository
public interface ApprovalRepository extends JpaRepository<Approval, Long> {
    // Additional query methods can be defined here if needed
}