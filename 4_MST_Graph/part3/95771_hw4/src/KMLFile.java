import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.LinkedList;

/**
 * The type Kml file.
 */
public class KMLFile {

    /**
     * To kml.
     *
     * @param list1  the list 1
     * @param list2  the list 2
     * @param crimes the crimes
     */
    public static void toKML(LinkedList<Integer> list1, LinkedList<Integer> list2, LinkedList<Crime> crimes) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("PGHCrimes.kml"));
            bw.write("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n");
            bw.write("<kml xmlns=\"http://earth.google.com/kml/2.2\">\n");
            bw.write("<Document>\n");
            bw.write("<name>Pittsburgh TSP</name><description>TSP on Crime</description><Style id=\"style6\">");
            bw.write("<LineStyle>\n");
            bw.write("<color>507800F0</color>\n" +
                    "<width>5</width>\n" +
                    "</LineStyle>\n" +
                    "</Style>\n" +
                    "<Placemark>\n" +
                    "<name>TSP Path</name>\n" +
                    "<description>TSP Path</description>\n" +
                    "<styleUrl>#style6</styleUrl>\n" +
                    "<LineString>\n" +
                    "<tessellate>1</tessellate>\n" +
                    "<coordinates>\n");
            for (int i = 1; i < list1.size(); i++) {
                try {
                    String[] info = crimes.get(list1.get(i)).getInfo().split("\\,");
                    bw.write(info[8] + "," + info[7] + "，0.000000" + "\n");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            bw.write("</coordinates>\n" +
                    "</LineString>\n" +
                    "</Placemark>\n" +
                    "<Placemark>\n" +
                    "<name>Optimal Path</name>\n" +
                    "<description>Optimal Path</description>\n" +
                    "<styleUrl>#style5</styleUrl>\n" +
                    "<LineString>\n" +
                    "<tessellate>1</tessellate>\n" +
                    "<coordinates>\n");
            for (int index1 : list2) {
                try {
                    String[] info = crimes.get(index1).getInfo().split("\\,");
                    bw.write(info[8] + "99999999999" + "," + info[7] + "99999999999"+ "，0.000000" + "\n");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            bw.write("</coordinates>\n" +
                    "</LineString>\n" +
                    "</Placemark>\n" +
                    "</Document>\n" +
                    "</kml>\n");
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Writing error.");
        }

        System.out.println("Writing completed.");
    }


}

