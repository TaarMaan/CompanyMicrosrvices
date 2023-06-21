package com.example.springclient.repository;

import com.example.springclient.models.UserDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Репозиторий для взаимодействий сущностей пользователь и компания
 */
public interface UserRepository extends JpaRepository<UserDTO, Long> {
    /**
     *
     * @param username Имя пользователя
     * @return Возвращает пользователя по имени
     */
    UserDTO findByUsername(String username);

    /**
     *
     * @param companyId Идентификатор компании
     * @return Возвращает список пользователей по id у которых companyId совпадают
     */
    @Modifying
    @Query(value = "SELECT * FROM users where company_id= :companyId", nativeQuery = true)
    List<UserDTO> findByCompany_id(Integer companyId);

    /**
     *
     * @param id удаляет компанию у вабранного по id пользоваотеля
     */
    @Modifying
    @Transactional
    @Query(value = "UPDATE users SET company_id = null WHERE id = :id", nativeQuery = true)
    void updateCompany_id(Integer id);
}
