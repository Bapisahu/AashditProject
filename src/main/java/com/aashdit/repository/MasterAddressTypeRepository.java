package com.aashdit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aashdit.entity.MasterAddressType;

public interface MasterAddressTypeRepository extends JpaRepository<MasterAddressType, Long>{
	 MasterAddressType findByAddressTypeCode(String addressTypeCode);
}
