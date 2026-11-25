package com.M.Dialisis.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryPaciente extends JpaRepository<Paciente, String> {
}