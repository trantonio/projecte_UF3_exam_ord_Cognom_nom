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

		try(BufferedReader br= new BufferedReader(new FileReader(inputFile))) {
			int i = 0;
			while ((line = br.readLine()) != null) {
				if (oneLine) {
					if (!line.isEmpty()) {
						String[] lineArray = line.split("" + betweenCells);
						if (lineArray.length == numColum) {
							new Districte(lineArray);
						}
					}
				} else {
					i++;
					if (i == 60) {
						oneLine = false;
					}
					if (i >= lineasEnBlanco) {
						String[] la = line.split("" + betweenCells);
						numColum = la.length;
						if (i > lineasEnBlanco) {
							oneLine = true;
						}
						if (i == lineasEnBlanco + 1) {
							if (!line.isEmpty()) {
								String[] lineArray = line.split("" + betweenCells);
								if (lineArray.length == numColum) {
									new Districte(lineArray);
								}
							}
						}
					}
				}
			}
			logFile = new File(outputFile);
			writer = new BufferedWriter(new FileWriter(logFile));
			String juntarBarrios = "";
			ArrayList<String> barriosConComas = new ArrayList<>();

			for (int j = 0; j < Districte.conjuntoBarrios.size(); j++) {
				System.out.println("-----"+Districte.conjuntoBarrios.get(i));
			}
			//  amb StringBuilder


			final StringBuilder sBHtml = new StringBuilder();
			final StringBuilder sBHtmlEnd = new StringBuilder();

			{

				sBHtml.append("<html>")
						.append(NL).append("<head>")
						.append(NL2).append("<meta charset=\"UTF-8\">")
						.append(NL2).append("<title>")
						.append(MY_NAME)
						.append("</title>")
						.append(NL2).append("<style>")
						.append(NL2).append("h2 {")
						.append(NL)
						.append("\t").append("font-style:italic;")
						.append(NL).append("}")
						.append(NL2)
						.append("td {")
						.append(NL)
						.append("\t").append("border: 1px solid black;")
						.append(NL)
						.append("\t").append("border-right: 3px solid black;")
						.append(NL)
						.append("\t").append("padding:8px;")
						.append(NL)
						.append("\t").append("text-align: center; ")
						.append(NL).append("}")
						.append(NL2)
						.append("table,th {")
						.append(NL)
						.append("\t").append("border: 3px solid black;")
						.append(NL)
						.append("\t").append("border-collapse:collapse;")
						.append(NL).append("}")
						.append(NL2).append("th {")
						.append(NL)
						.append("\t").append("background-color: #D3D5D8;")
						.append(NL)
						.append("\t").append("padding-bottom:10px;")
						.append(NL)
						.append("\t").append("padding-top:10px;")
						.append(NL).append("}")
						.append(NL2).append(".l {")
						.append(NL)
						.append("\t").append("text-align: left; ")
						.append(NL)
						.append("\t").append("width:65%;")
						.append(NL).append("}")
						.append(NL2).append(".r {")
						.append(NL)
						.append("\t").append("text-align: right;")
						.append(NL)
						.append("\t").append("padding-right:20px;")
						.append(NL).append("}")
						.append(NL2).append(".res {")
						.append(NL)
						.append("\t").append("margin-left:auto;")
						.append(NL)
						.append("\t").append("margin-right:auto;")
						.append(NL)
						.append("\t").append("padding:50px;")
						.append(NL)
						.append("\t").append("width:80%;")
						.append(NL).append("}")
						.append(NL2).append("</style>")
						.append(NL2).append("</head>")
						.append(NL2).append("<body>")
						.append(NL2).append("<div class=\"res\"><h2>")
						.append("Emigrants a Barcelona any 2012")
						.append("</h2>")
						.append(NL2).append("<table>")
						.append(NL)
						.append("<tr><th>  Districte</th> <th>Total</th> <th>% Homes</th> <th>% Dones</th></tr>")
						.append(NL)
				;

			}
			for (Districte districte:Districte.districteArrayList) {
				sBHtml.append("<tr><td>");
				Boolean unaVez = true;
				for (int j = 0; j < Districte.districteArrayList.size(); j++) {
					if (unaVez) {
						juntarBarrios = Districte.districteArrayList.get(j).getBarris() + ", ";
						unaVez = false;
					} else {
						if (Districte.districteArrayList.get(j).getDistricte() == Districte.districteArrayList.get(j - 1).getDistricte()) {
							juntarBarrios = juntarBarrios + Districte.districteArrayList.get(j).getBarris() + ", ";
						} else {
							barriosConComas.add(juntarBarrios);
							sBHtml.append(juntarBarrios);
							juntarBarrios = "";
							unaVez = true;
							j--;
						}
//						System.out.println(Districte.districteArrayList.get(j).getBarris());
					}
				}
				sBHtml.append("</td> <td>").append(districte.getTotal()).append("</td> <td>").append(districte.getDonesPorcentajes()).append("</td> <td>").append(districte.getDonesPorcentajes()).append("</td></tr>")
						.append( NL );
			}
			try (BufferedWriter out = new BufferedWriter(new FileWriter(outputFile))) {
				out.write(sBHtml.toString());
				out.write(sBHtmlEnd.toString());
			} catch (Exception e) {
				return false;
			}


		}catch (IOException e){
			e.printStackTrace();
		}

		return true;
	}

}
