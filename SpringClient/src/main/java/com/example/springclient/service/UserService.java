package com.example.springclient.service;

import com.example.springclient.models.UserDTO;
import com.example.springclient.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    /**
     *
     * @return Возвращает список пользователей
     */
    public List<UserDTO> getAll() {
        return userRepository.findAll();
    }

    /**
     *
     * @param id идентификатор пользователя в бд
     * @return Возвращает юзера по id
     */
    public Optional<UserDTO> getById(long id) {
        return userRepository.findById(id);
    }

    /**
     *
     * @param newUser Сущность нового пользователя
     * @return Сохранение пользователя в БД
     */
    public UserDTO save(UserDTO newUser) {
        return userRepository.save(newUser);
    }

    /**
     * Удаление пользователя из БД
     *
     * @param id
     */
    public void delete(long id) {
        userRepository.deleteById(id);
    }

    /**
     *
     * @param username Имя пользователя
     * @return Возвращает пользователя по имени
     */
    public UserDTO findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    /**
     *
     * @param id
     * @return Показывает пользователя по id
     */
    public boolean findByUserId(long id) {
        return userRepository.findById(id).isPresent();
    }

    /**
     *
     * @param id
     * @return Возвращает пользователя по id
     */
    public UserDTO getByUserId(long id) {
        return userRepository.getOne(id);
    }

    /**
     *
     * @param companyId Идентификатор компании
     * @return Возвращает компанию по id
     */
    public List<UserDTO> findByCompanyId(Integer companyId) {
        return userRepository.findByCompany_id(companyId);
    }

    /**
     *
     * @param id Обновляет данные компании по id
     */
    public void updateCompany(Integer id) {
        userRepository.updateCompany_id(id);
    }
}
