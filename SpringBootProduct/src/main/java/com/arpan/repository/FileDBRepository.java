package com.arpan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arpan.beans.FileDB;


@Repository
public interface FileDBRepository extends JpaRepository<FileDB, String>{

}
