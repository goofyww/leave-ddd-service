package ddd.leave.domain.person.repository.persistence;

import ddd.leave.domain.person.repository.po.PersonPO;
import ddd.leave.domain.person.repository.facade.PersonRepository;
import ddd.leave.domain.person.repository.mapper.PersonDao;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class PersonRepositoryImpl implements PersonRepository {

    @Resource
    private PersonDao personDao;

    @Override
    public void insert(PersonPO personPO) {
        personDao.save(personPO);
    }

    @Override
    public void update(PersonPO personPO) {
        personDao.save(personPO);
    }

    @Override
    public PersonPO findById(String id) {
        return personDao.findById(id).orElseThrow(() -> new RuntimeException("未找到用户"));
    }

    @Override
    public PersonPO findLeaderByPersonId(String personId) {
        return personDao.findLeaderByPersonId(personId);
    }

}
