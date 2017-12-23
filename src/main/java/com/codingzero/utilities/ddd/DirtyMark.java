package com.codingzero.utilities.ddd;

public class DirtyMark {

    private boolean isDirty;
    private boolean isNew;
    private boolean isVoid;

    public DirtyMark() {
        cleanMarks();
    }

    public void markAsDirty() {
        if (!isDirty()) {
            checkForVoidMark();
            isDirty = true;
        }
    }

    public boolean isDirty() {
        return isDirty;
    }

    public void markAsNew() {
        if (!isNew()) {
            cleanMarks();
            isNew = true;
        }
    }

    public boolean isNew() {
        return isNew;
    }

    public void markAsVoid() {
        if (!isVoid()) {
            cleanMarks();
            isVoid = true;
        }
    }

    public boolean isVoid() {
        return isVoid;
    }

    public boolean isClean() {
        return (!this.isNew() && !this.isDirty() && !this.isVoid());
    }

    public void cleanMarks() {
        checkForVoidMark();
        isDirty = false;
        isNew = false;
    }

    private void checkForVoidMark() {
        if (isVoid()) {
            throw new IllegalStateException("Cannot remark an void entity");
        }
    }

    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (isVoid ? 1231 : 1237);
        result = prime * result + (isDirty ? 1231 : 1237);
        result = prime * result + (isNew ? 1231 : 1237);
        return result;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        DirtyMark other = (DirtyMark) obj;
        if (isVoid != other.isVoid) {
            return false;
        }
        if (isDirty != other.isDirty) {
            return false;
        }
        if (isNew != other.isNew) {
            return false;
        }
        return true;
    }
}