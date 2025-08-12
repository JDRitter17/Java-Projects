package chessset;

public class Position {
    public int fileIndex;
    public int rankIndex;

    public Position(char file, int rank){
        fileIndex = (int)(file - 'a');
        rankIndex = rank - 1;
    }

    public Position(int fileIndex, int rankIndex){
        this.fileIndex = fileIndex;
        this.rankIndex = rankIndex;
    }

    public char getFile(){
        return (char)(fileIndex + 'a');
    }

    public int getRank(){
        return rankIndex + 1;
    }

    @Override
    public String toString(){
        return "" + getFile() +  getRank();
    }

    @Override
    public boolean equals(Object other){
        if(other.getClass() != this.getClass()){
            return false;
        }
        Position otherPos = (Position)other;
        return otherPos.fileIndex == fileIndex 
                && otherPos.rankIndex == rankIndex;
    }

    @Override
    public int hashCode(){
        return fileIndex + 8 * rankIndex;
    }
}
