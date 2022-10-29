package vkg.springframework.vkgpetclinic.services;

import vkg.springframework.vkgpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {
    Owner findByLastName(String lastName);
}
