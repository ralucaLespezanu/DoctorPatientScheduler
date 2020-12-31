package wantsome.project;

public class SpecializationsDTO {

    private Integer id;
    private String description;

    public SpecializationsDTO(Integer id, String description) {
        this.id = id;
        this.description = description;
    }

    public SpecializationsDTO(Specializations specializations) {
        this.id = specializations.getId();
        this.description = specializations.getDescription();
    }

    public Specializations toSpecializations() {
        Specializations specializations = new Specializations();
        specializations.setId(this.id);
        specializations.setDescription(this.description);
        return specializations;
    }

    public Integer getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }
}
