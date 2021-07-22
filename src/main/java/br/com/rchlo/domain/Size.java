package br.com.rchlo.domain;

public enum Size {

    SMALL("Pequeno"),
    MEDIUM("Médio"),
    LARGE("Grande"),
    EXTRA_LARGE("Extra-grande");

    private String description;

    Size(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}
