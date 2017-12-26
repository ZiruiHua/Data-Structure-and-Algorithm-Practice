import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;

public class Graph {
    /**
     * The List. hold all crime nodes within the date range
     */
    Crime[] array;
    /**
     * The Nodes.number of crimes in the list
     */
    int nodes;
    /**
     * The Graph. 2-d array recording distance between two records
     */
    double[][] graph;
    /**
     * Instantiates a new graph according to user input.
     *
     * @param start the start time by user input
     * @param end   the end time
     */
    public Graph(String start, String end) {
        findCoordinates(findTime(start, end));
        constructGraph();
    }
    /**
     * Find time int [ ].
     * both of the parameters are "DATE" field in CSV file
     *
     * @param startDate the start date according to user input
     * @param endDate   the end date
     * @return the int [ ] index 0 start time, index 1 end time
     */
    public int[] findTime(String startDate, String endDate) {
        //read data from crime csv
        Path questionPath = Paths.get("CrimeLatLonXY1990.csv");
        File questionFile = questionPath.toFile();
        FileReader reader;
        BufferedReader br;
        String startTime = null, endTime = null;
        int[] res = new int[2];
        String columns[] = null;
        try {
            reader = new FileReader(questionFile);
            br = new BufferedReader(reader);
            String str = null;
            try {
                while ((str = br.readLine()) != null) {
                    columns = str.split("\\,");
                    try {
                        // get data and time info from file
                        String date = columns[5].trim();
                        String time = columns[2].trim();
                        // get corresponding time info according to date
                        if (date.equals(startDate)) {
                            startTime = time;
                        }
                        if (date.equals(endDate)) {
                            endTime = time;
                        }
                        // if finished find, return found value
                        if (startTime != null && endTime != null) {
                            res[0] = Integer.parseInt(startTime);
                            res[1] = Integer.parseInt(endTime);
                            return res;
                        }
                    } catch (NumberFormatException e) {
                        //skip the first line
                        continue;
                    }

                }
            } catch (IOException ex) {
                ex.printStackTrace();

            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    /**
     * Find coordinates. Called by constructor to find all crime records within a time range
     *
     * @param times the times int[] array, 0,1  is start and end time, according to "TIME" field in CSV file
     */
    public void findCoordinates(int[] times) {
        int startTime = times[0];
        int endTime = times[1];
        int index = 0;
        Path questionPath = Paths.get("CrimeLatLonXY1990.csv");
        File questionFile = questionPath.toFile();
        FileReader reader;
        BufferedReader br;
        //int[] res = new int[2];
        String columns[] = null;
        LinkedList<Crime> list = new LinkedList<>();
        try {
            // read CSV file
            reader = new FileReader(questionFile);
            br = new BufferedReader(reader);
            String str = null;
            try {
                while ((str = br.readLine()) != null) {
                    columns = str.split("\\,");
                    try {
                        //0,1 are the coordinates x, y
                        double x = Double.parseDouble(columns[0].trim());
                        double y = Double.parseDouble(columns[1].trim());
                        // 2 is time field
                        int time = Integer.parseInt(columns[2].trim());
                        if (time <= endTime && time >= startTime) {
                            // create a Crime instance within the time range
                            Crime crime = new Crime(x, y, index++, str);
                            list.add(crime);
                        }
                        //stop reading file after we have found the last crime at the end time
                        if (time > endTime) {
                            nodes = index;
                            array = new Crime[index];
                            // construct crime array
                            for (int i = 0; i < index; i++) {
                                array[i] = list.get(i);
                            }
                            break;
                        }
                    } catch (NumberFormatException e) {
                        //skip the first line
                        continue;
                    }

                }
            } catch (IOException ex) {
                ex.printStackTrace();

            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Construct graph.
     * graph[x][y] means the square distance from x to y
     */
    public void constructGraph() {
        graph = new double[array.length][array.length];
        for (int i = 0; i < graph.length; i++) {
            Crime c1 = array[i];
            for (int j = 0; j < graph.length; j++) {
                Crime c2 = array[j];
                graph[i][j] = ((c1.getX() - c2.getX()) * (c1.getX() - c2.getX()) +
                        (c1.getY() - c2.getY()) * (c1.getY() - c2.getY()));
            }
        }
    }
}
