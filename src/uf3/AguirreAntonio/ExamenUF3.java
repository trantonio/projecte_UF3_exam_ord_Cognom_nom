package uf3.AguirreAntonio;

/*

	@author		AntonioAguirre
	
	GNU
	

*/

import java.io.*;
import java.util.ArrayList;

public class ExamenUF3 {

	public final static String NL="\n";
	public final static String NL2=NL+NL;
	public final static String MY_NAME="Antonio Aguirre";


	public static boolean poblacioImmigrantCompactHTML(String inputFile, String outputFile, char betweenCells, char quote) {

		String line ="";
		int lineasEnBlanco = 6;
		int numColum = 0;
		boolean oneLine = false;

		File logFile = null;
		BufferedWriter writer = null;

		try(BufferedReader br= new BufferedReader(new FileReader(inputFile))){
			int i =0;
			while((line = br.readLine())!=null){
				if(oneLine) {
					if (!line.isEmpty()) {
						String[] lineArray = line.split(""+betweenCells);
						if(lineArray.length==numColum){
							new Districte(lineArray);
						}
					}
				}else {
					i++;
					if(i==60){
						oneLine=false;
					}
					if(i>=lineasEnBlanco) {
						String[] la = line.split(""+betweenCells);
						numColum = la.length;
						if (i>lineasEnBlanco) {
							oneLine = true;
						}
						if (i == lineasEnBlanco+1){
							if (!line.isEmpty()) {
								String[] lineArray = line.split(""+betweenCells);
								if(lineArray.length==numColum){
									new Districte(lineArray);
								}
							}
						}
					}
				}
			}
			logFile = new File(outputFile);
			writer = new BufferedWriter(new FileWriter(logFile));
			String juntarBarrios ="";
			ArrayList<String> barriosConComas= new ArrayList<>();
			Boolean unaVez = true;
			for (int j = 0; j <Districte.districteArrayList.size() ; j++) {
				if(unaVez){
					juntarBarrios = Districte.districteArrayList.get(j).getBarris() + ", ";
					unaVez=false;
				}else {
					if (Districte.districteArrayList.get(j).getDistricte() == Districte.districteArrayList.get(j - 1).getDistricte()) {
						juntarBarrios = juntarBarrios + Districte.districteArrayList.get(j).getBarris() + ", ";
					} else {
						barriosConComas.add(juntarBarrios);
						juntarBarrios = "";
						unaVez=true;
						j--;
					}

				}
			}
			for (int k = 0; k < barriosConComas.size(); k++) {
				System.out.println(barriosConComas.get(k));
			}
			String sHtml = "<html>" + NL
					+ "<head>" + NL2
					+ "<meta charset=\"UTF-8\">" + NL2
					+ "<title>" + MY_NAME + "</title>" + NL2
					+ "<style>" + NL2
					+ "h2 {" + NL  + "\t"
					+ "font-style:italic;" + NL
					+ "}" + NL2

					+ "td {" + NL + "\t"
					+ "border: 1px solid black;" + NL + "\t"
					+ "border-right: 3px solid black;" + NL + "\t"
					+ "padding:8px;" + NL + "\t"
					+ "text-align: center; "+NL
					+ "}" + NL2


					+ "table,th {" + NL + "\t"
					+ "border: 3px solid black;" + NL + "\t"
					+ "border-collapse:collapse;" + NL
					+ "}" + NL2

					+"th {" + NL + "\t"
					+ "background-color: #D3D5D8;" + NL + "\t"
					+ "padding-bottom:10px;" + NL + "\t"
					+ "padding-top:10px;" + NL
					+ "}" + NL2

					+ ".l {" + NL + "\t"
					+ "text-align: left; " + NL + "\t"
					+ "width:65%;" + NL
					+ "}" + NL2

					+ ".r {" + NL + "\t"
					+ "text-align: right;" + NL + "\t"
					+ "padding-right:20px;" + NL
					+ "}"	 + NL2

					+ ".res {" + NL + "\t"
					+"margin-left:auto;" + NL + "\t"
					+ "margin-right:auto;" + NL + "\t"
					+ "padding:50px;" + NL + "\t"
					+ "width:80%;" + NL
					+ "}" + NL2
					+ "</style>" + NL2
					+ "</head>" + NL2
					+ "<body>" + NL2
					+ "<div class=\"res\"><h2>"+"Emigrants a Barcelona any 2012"+"</h2>" + NL2
					+ "<table>" + NL
					+ "<tr><th>  Districte</th>"+
					" <th>Total</th> <th>% Homes</th> <th>% Dones</th></tr>" + NL+
					"<tr>";
					for (int k = 0; k < barriosConComas.size(); k++) {
						sHtml= sHtml+ "<td>"+ barriosConComas.get(k)+"</td>";
					}
					sHtml = sHtml+"</tr>";
			 sHtml = sHtml +"</table>" + NL2
					+"</body>" + NL2
					+"</html>";
			writer.write(sHtml);
			writer.close();


		}catch (IOException e){
			e.printStackTrace();
		}

		return true;
	}

}
