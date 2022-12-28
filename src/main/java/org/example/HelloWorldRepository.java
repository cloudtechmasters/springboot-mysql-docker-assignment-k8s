package org.example;

import org.springframework.data.repository.CrudRepository;

public interface HelloWorldRepository extends CrudRepository<HelloWorld, Long> {
}
