package models;

import java.util.Date;

public abstract class BaseClass {
    private int id;
    private Date currentDate;
    private Date updatedDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(Date currentDate) {
        this.currentDate = currentDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }
}

/*
/*
BaseClass serves as a foundational superclass for all model entities, ensuring consistent inclusion of core attributes
such as `id`, `currentDate`, and `updatedDate` across the codebase. This promotes maintainability,
enforces a unified data structure, and streamlines future enhancements or auditing requirements.
 */


