import java.util.Arrays;
import java.util.Vector;
import java.util.stream.IntStream;

public class BattleshipFieldValidatorMk2 {
    private int[][] field;

    public BattleshipFieldValidatorMk2(int[][] field) {
        this.field = field;
    }

    public boolean validate() {
        //Check sum of all the elements is correct (no ships missing/no overlapping ships).
        if (!checkSumOfElements()) return false;

        //Store the currently possible configurations.
        Vector<int[][]> possibleFields = new Vector<>();
        possibleFields.add(field);

        //Remove the ship of size 4 first. Update the possible configurations.
        //(since it could potentially be removed from multiple places in the array).
        possibleFields = removeShipsFromFields(1, 4, possibleFields);
        if (possibleFields.isEmpty()) return false; //If we couldn't remove a ship of size 4 -> Configuration is invalid

        //Remove 2 ships of size 3. Update the possible configurations.
        possibleFields = removeShipsFromFields(2, 3, possibleFields);
        if (possibleFields.isEmpty()) return false;

        //Remove 3 ships of size 2. Update the possible configurations.
        possibleFields = removeShipsFromFields(3, 2, possibleFields);
        if (possibleFields.isEmpty()) return false;

        return true; //Can always remove 4x1 ships if there are 4 1's remaining. Configuration is valid.
    }

    private Vector<int[][]> removeShipsFromFields(int numberOfShips, int lengthOfShip, Vector<int[][]> possibleFields) {
        Vector<int[][]> newPossibleFields = new Vector<>();

        for (int[][] field : possibleFields) {
            Vector<int[][]> newField = findAndReplaceShips(numberOfShips, lengthOfShip, field);
            newPossibleFields.addAll(newField);
        }
        return newPossibleFields;
    }

    private Vector<int[][]> findAndReplaceShips(int numberOfShips, int lengthOfShip, int[][] inputField) {
        Vector<int[][]> fieldsInCurrentIteration = new Vector<>();
        fieldsInCurrentIteration.add(inputField);
        Vector<int[][]> fieldsForNextIteration = new Vector<>();

        //Remove the ships one at a time. Vector fieldsForNextIteration contains the fields for all possible removal locations.
        for (int n = 0; n < numberOfShips; n++) {
            for (int[][] field : fieldsInCurrentIteration) {
                int count = 0;
                //Search rows and columns.
                for (int i = 0; i < field.length; i++) {
                    //Rows.
                    int[] row = field[i];
                    for (int j = 0; j < row.length; j++) {
                        int entry = row[j];

                        //Increment count if there is an adjacent 1. Reset otherwise.
                        if (entry == 1) count++;
                        else {
                            count = 0;
                            continue;
                        }

                        //We have found a ship of the right length. Remove it by setting all its entries to zero.
                        // Add this newly created field to the vector for the next iteration.
                        if (count == lengthOfShip) {
                            int[][] newField = Arrays.stream(field).map(int[]::clone).toArray(int[][]::new);
                            for (int k = 0; k < lengthOfShip; k++) {
                                newField[i][j - k] = 0;
                            }
                            fieldsForNextIteration.add(newField);

                            //Reset the count and increment removals.
                            count = 0;

                            //Start iterating from the entry after the start of the ship.
                            j = j - lengthOfShip + 1;
                        }

                        //Reset the count for the next row.
                        if (j == row.length - 1) count = 0;
                    }

                    //Columns.
                    int[] column = getColumn(field, i);
                    for (int j = 0; j < column.length; j++) {
                        int entry = column[j];

                        //Increment count if there is an adjacent 1. Reset otherwise.
                        if (entry == 1) count++;
                        else {
                            count = 0;
                            continue;
                        }

                        //We have found a ship of the right length. Remove it by setting all its entries to zero.
                        if (count == lengthOfShip) {
                            int[][] newField = Arrays.stream(field).map(int[]::clone).toArray(int[][]::new);
                            for (int k = 0; k < lengthOfShip; k++) {
                                newField[j - k][i] = 0;
                            }
                            fieldsForNextIteration.add(newField);

                            //Reset the count and increment removals.
                            count = 0;

                            //Start iterating from the entry after the start of the ship.
                            j = j - lengthOfShip + 1;
                        }

                        //Reset the count for the next col.
                        if (j == column.length - 1) count = 0;
                    }
                }
            }
            //Finished creating fields for the next iteration.
            fieldsInCurrentIteration.removeAllElements();
            fieldsInCurrentIteration.addAll(fieldsForNextIteration);
            fieldsForNextIteration.removeAllElements();
        }
        return fieldsInCurrentIteration;
    }

    private boolean checkSumOfElements() {
        //Sum elements.
        int sum = Arrays.stream(field).flatMapToInt(Arrays::stream).sum();

        //1x4 + 2x3 + 3x2 + 4x1 = 20
        return sum == 20;
    }

    private int[] getColumn(int[][] matrix, int column) {
        return IntStream.range(0, matrix.length).map(i -> matrix[i][column]).toArray();
    }
}
