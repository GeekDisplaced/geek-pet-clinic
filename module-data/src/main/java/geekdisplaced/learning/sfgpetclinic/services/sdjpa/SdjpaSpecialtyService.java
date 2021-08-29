package geekdisplaced.learning.sfgpetclinic.services.sdjpa;

import geekdisplaced.learning.sfgpetclinic.model.Specialty;
import geekdisplaced.learning.sfgpetclinic.repositories.SpecialtyRepository;
import geekdisplaced.learning.sfgpetclinic.services.SpecialtyService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("sdjpa")
public class SdjpaSpecialtyService extends SdjpaAbstractService implements SpecialtyService {

    private final SpecialtyRepository specialtyRepository;

    public SdjpaSpecialtyService(SpecialtyRepository specialtyRepository) {
        this.specialtyRepository = specialtyRepository;
    }

    @Override
    public Set<Specialty> findAll() {

        Set<Specialty> specialties = new HashSet<>();

        specialtyRepository.findAll().forEach(specialties::add);

        return specialties;
    }

    @Override
    public Specialty findById(Long id) {

        return specialtyRepository.findById(id).orElse(null);
    }

    @Override
    public Specialty save(Specialty object) {

        return specialtyRepository.save(object);
    }

    @Override
    public void delete(Specialty object) {

        specialtyRepository.delete(object);
    }

    @Override
    public void deleteById(Long id) {

        specialtyRepository.deleteById(id);
    }
}
