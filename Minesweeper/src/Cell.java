public class Cell{
    Integer adjacentMines = 0;
    boolean isVisible = false;
    boolean isMine = false;
    boolean isFlagged = false;
    boolean isShowingAdjacencies = false;
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

//    public Cell(boolean showMines, boolean enableColors){
//        this.showMines = showMines;
//        this.enableColors = enableColors;
//    }


    private String getStatus() {
        if (isVisible) {
            return this.getExposedStatus();
        } else if (isFlagged) {
            return " F";
        } else if (isShowingAdjacencies){
            return " S";
        } else {
            return " #";
        }
    }

    public String getExposedStatus(){
        if (isMine){
            return " M";

        } else {
            if (adjacentMines < 10){
                return "0" + adjacentMines;
            }
            return adjacentMines.toString();
        }
    }

    // do color here
    @Override
    public String toString() {
        if (getStatus().equals(" #")){
            return "\u001B[32m" + "[" + layer + height + depth + width + " " + getStatus() + "]" + "\u001B[0m";
        } else if (getStatus().equals(" F")){
            return "\u001B[31m" + "[" + layer + height + depth + width + " " + getStatus() + "]" + "\u001B[0m";
        } else if (getStatus().equals("00")){
            return "\u001B[30m" + "[" + layer + height + depth + width + " " + getStatus() + "]" + "\u001B[0m";
        } else if (getStatus().equals(" S")) {
            setShowingAdjacencies(false);
            return "\u001B[33m" + "[" + layer + height + depth + width + " " + getStatus() + "]" + "\u001B[0m";
        }
        return "[" + layer + height + depth + width + " " + getStatus() + "]";
    }

    public String toExposedString() {
        if (getExposedStatus().equals(" M")){
            return "\u001B[31m" + "[" + layer + height + depth + width + " " + getExposedStatus() + "]" + "\u001B[0m";
        } else if (getExposedStatus().equals(" F")){
            return "\u001B[31m" + "[" + layer + height + depth + width + " " + getExposedStatus() + "]" + "\u001B[0m";
        } else if (getExposedStatus().equals("00")){
            return "\u001B[30m" + "[" + layer + height + depth + width + " " + getExposedStatus() + "]" + "\u001B[0m";
        }
        return "[" + layer + height + depth + width + " " + getExposedStatus() + "]";
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

    public void setShowingAdjacencies(boolean showingAdjacencies) {
        isShowingAdjacencies = showingAdjacencies;
    }
}
