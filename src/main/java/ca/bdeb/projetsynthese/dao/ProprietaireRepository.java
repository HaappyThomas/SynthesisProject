package ca.bdeb.projetsynthese.dao;

import ca.bdeb.projetsynthese.models.Proprietaire;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class ProprietaireRepository implements JpaRepository<Proprietaire, Integer> {
    @Override
    public List<Proprietaire> findAll() {
        return null;
    }

    @Override
    public List<Proprietaire> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Proprietaire> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Proprietaire> findAllById(Iterable<Integer> integers) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public void delete(Proprietaire entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends Proprietaire> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends Proprietaire> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Proprietaire> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Proprietaire> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Proprietaire> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Proprietaire> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Proprietaire> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Integer> integers) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Proprietaire getOne(Integer integer) {
        return null;
    }

    @Override
    public Proprietaire getById(Integer integer) {
        return null;
    }

    @Override
    public Proprietaire getReferenceById(Integer integer) {
        return null;
    }

    @Override
    public <S extends Proprietaire> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Proprietaire> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Proprietaire> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Proprietaire> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Proprietaire> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Proprietaire> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Proprietaire, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }
}
