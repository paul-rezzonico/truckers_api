package com.paulrezzonico.repository

import com.paulrezzonico.Modele.NumeroDeTelephone
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface INumeroDeTelephone : JpaRepository<NumeroDeTelephone, Long>
