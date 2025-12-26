public interface FacilityScoreRepository extends JpaRepository<FacilityScore, Long> {
    Optional<FacilityScore> findByProperty(Property property);
    List<FacilityScore> findAllByProperty(Property property);
}