package org.example.seata.oracle.hibernate.account;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author chenjia
 * @date : 2021/2/20 16:48
 */
@Repository
public interface AccountDao extends JpaRepository<AccountEntity, Long> {

}
