///*
// *         File : PersonRepository.java
// *    Classname : PersonRepository
// *    Author(s) : eznlzhi
// *      Created : 2018-05-09
// *
// * Copyright (c) 2017 Ericsson AB, Sweden.
// * All rights reserved.
// * The Copyright to the computer program(s) herein is the property of
// * Ericsson AB, Sweden.
// * The program(s) may be used and/or copied with the written permission
// * from Ericsson AB or in accordance with the terms and conditions
// * stipulated in the agreement/contract under which the program(s)
// * have been supplied.
// *
// */
//
//package com.example.webdemo.test.gemfire;
//
//import org.springframework.data.repository.CrudRepository;
//import org.springframework.data.repository.query.Param;
//import org.springframework.data.rest.core.annotation.RepositoryRestResource;
//
//import java.util.List;
//
//@RepositoryRestResource(collectionResourceRel = "people", path = "people")
//public interface PersonRepository extends CrudRepository<Person, Long> {
//    List<Person> findPersonByLastName(@Param("name") String name);
//}
