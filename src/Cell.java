public class Cell {
    Integer adjacentMines = 0;
    boolean isVisible = false;
    boolean isMine = false;
    boolean isFlagged = false;
    int height = 0;
    int width = 0;
    int depth = 0;
    int layer = 0;

    public Cell(int layer, int depth, int height, int width) {
        this.layer = layer;
        this.depth = depth;
        this.height = height;
        this.width = width;
    }


    private String getStatus(){
        if(isVisible){
            return this.getExposedStatus();
        } else if(isFlagged){
            return " F";
        } else {
            return " #";
        }
    }

    private String getExposedStatus(){
        if (isMine){
            return " M";
        } else {
            if (adjacentMines < 10){
                return "0" + adjacentMines.toString();
            }
            return adjacentMines.toString();
        }
    }

    @Override
    public String toString() {
        return "[" + layer + depth + height + width + " " + getStatus() + "]" ;
    }

    public String toExposedString() {
        return "[" + layer + depth + height + width + " " + getExposedStatus() + "]" ;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public int getLayer() {
        return layer;
    }

    public void setLayer(int layer) {
        this.layer = layer;
    }

    public int getAdjacentMines() {
        return adjacentMines;
    }

    public void setAdjacentMines(int adjacentMines) {
        this.adjacentMines = adjacentMines;
    }

    public boolean isVisible() {
        return isVisible;
    }

    public void setVisible(boolean visible) {
        isVisible = visible;
    }

    public boolean isMine() {
        return isMine;
    }

    public void setMine(boolean mine) {
        isMine = mine;
    }

    public boolean isFlagged() {
        return isFlagged;
    }

    public void setFlagged(boolean flagged) {
        isFlagged = flagged;
    }
}
