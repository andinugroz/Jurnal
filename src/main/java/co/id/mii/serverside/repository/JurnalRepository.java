package co.id.mii.serverside.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import co.id.mii.serverside.models.Jurnal;

public interface JurnalRepository extends JpaRepository<Jurnal, Long> {
    // JPQL for Native Query
    @Query(value = "SELECT * FROM tb_jurnal WHERE status = ?1", nativeQuery = true)
    List<Jurnal> findAllstatusNative(String status);

    @Query(value = "SELECT * FROM tb_jurnal WHERE status='Reject' OR status='Pending'", nativeQuery = true)
    List<Jurnal> findAlladdjurnalNative();
}
