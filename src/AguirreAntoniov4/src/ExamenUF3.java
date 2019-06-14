package AguirreAntoniov4.src;

/*

	@author		// TODO
	
	GNU
	

*/

import java.io.*;
import java.util.ArrayList;

public class ExamenUF3 {


	private static final Districte DISTRICTE=new Districte(" ");
	public final static String NL="\n";
	public final static String NL2=NL+NL;
	public final static String MY_NAME="Ivan Cubero";


	public static boolean poblacioImmigrantCompactHTML(String inputFile, String outputFile, char betweenCells, char quote) {


		String line;
		ArrayList<Districte> distList = new ArrayList<Districte>();
		ArrayList<Districte> distSet = new ArrayList<Districte>();
		String any="";

		if(!inputFile.endsWith(".csv")||(!outputFile.endsWith(".txt")&&!outputFile.endsWith(".html"))){
			return false;
		}


//Con el Try con recursos leere el archivo
		try (BufferedReader br = new BufferedReader(new FileReader(new File(inputFile)))) {
			while ((line= br.readLine())!=null){
				String[] lineaArray = line.split(betweenCells+"");
				if(lineaArray.length<1){
					continue;
				}else if(lineaArray[0]!=null&&lineaArray[0].startsWith("Any")){
					any=lineaArray[0].replace("Any ","");
					continue;
				}else if(lineaArray.length<4||lineaArray[3]==null||!lineaArray[3].matches("^\"?[0-9]+[.].*")){
					continue;
				}


				DISTRICTE.setIdDistricte(lineaArray[1]);
				if(!distSet.contains(DISTRICTE)){
					Districte districte = new Districte(lineaArray[1]);
					districte.addCarrer(lineaArray[3],Integer.parseInt(lineaArray[4].replace(".","")),Integer.parseInt(lineaArray[5].replace(".","")),Integer.parseInt(lineaArray[6].replace(".","")));
					distList.add(districte);
					distSet.add(districte);
				}else {
					for (Districte dist:distList) {
						if(dist.equals(DISTRICTE)){
							dist.addCarrer(lineaArray[3],Integer.parseInt(lineaArray[4].replace(".","")),Integer.parseInt(lineaArray[5].replace(".","")),Integer.parseInt(lineaArray[6].replace(".","")));
						}
					}
				}
			}
		}catch (Exception e){
			return false;
		}


//  amb StringBuilder


		final StringBuilder sBHtml = new StringBuilder();
		final StringBuilder sBHtmlEnd = new StringBuilder();

		{

			sBHtml.append( "<html>" )
					.append( NL ).append( "<head>" )
					.append( NL2 ).append( "<meta charset=\"UTF-8\">" )
					.append( NL2 ).append( "<title>" )
					.append( MY_NAME )
					.append( "</title>" )
					.append( NL2 ).append( "<style>" )
					.append( NL2 ).append( "h2 {" )
					.append( NL  )
					.append( "\t" ).append( "font-style:italic;" )
					.append( NL ).append( "}" )
					.append( NL2 )
					.append( "td {" )
					.append( NL )
					.append( "\t" ).append( "border: 1px solid black;" )
					.append( NL )
					.append( "\t" ).append( "border-right: 3px solid black;" )
					.append( NL )
					.append( "\t" ).append( "padding:8px;" )
					.append( NL )
					.append( "\t").append( "text-align: center; ")
					.append( NL ).append( "}" )
					.append( NL2 )
					.append( "table,th {" )
					.append( NL )
					.append( "\t").append( "border: 3px solid black;" )
					.append( NL )
					.append( "\t").append( "border-collapse:collapse;" )
					.append( NL).append( "}" )
					.append( NL2 ).append("th {" )
					.append( NL )
					.append( "\t" ).append( "background-color: #D3D5D8;" )
					.append( NL )
					.append( "\t" ).append( "padding-bottom:10px;" )
					.append( NL )
					.append( "\t" ).append( "padding-top:10px;" )
					.append( NL ).append( "}" )
					.append( NL2 ).append( ".l {" )
					.append( NL )
					.append( "\t" ).append( "text-align: left; " )
					.append( NL )
					.append( "\t" ).append( "width:65%;" )
					.append( NL ).append( "}" )
					.append( NL2 ).append( ".r {" )
					.append( NL )
					.append( "\t" ).append( "text-align: right;" )
					.append( NL )
					.append( "\t" ).append( "padding-right:20px;" )
					.append( NL ).append( "}"	 )
					.append( NL2 ).append( ".res {" )
					.append( NL )
					.append( "\t" ).append("margin-left:auto;" )
					.append( NL )
					.append( "\t" ).append( "margin-right:auto;" )
					.append( NL )
					.append( "\t" ).append( "padding:50px;" )
					.append( NL )
					.append( "\t" ).append( "width:80%;" )
					.append( NL ).append( "}" )
					.append( NL2 ).append( "</style>" )
					.append( NL2 ).append( "</head>" )
					.append( NL2 ).append( "<body>" )
					.append( NL2 ).append( "<div class=\"res\"><h2>" )
					.append( "Emigrants a Barcelona any ").append(any)
					.append( "</h2>" )
					.append( NL2 ).append( "<table>" )
					.append( NL )
					.append("<tr><th>  Districte</th> <th>Total</th> <th>% Homes</th> <th>% Dones</th></tr>")
					.append( NL )
			;

			distList.sort(Districte::compareTo);
			for (Districte dist:distList) {
				sBHtml.append("<tr><td>");
				boolean first=true;
				for (String carrer:dist.getCarrers()) {
					if(!first){
						sBHtml.append(", ");
					}else {
						first=false;
					}
					sBHtml.append(carrer);
				}
						sBHtml.append("</td> <td>").append(dist.getTotal()).append("</td> <td>").append(dist.percHomes()).append("</td> <td>").append(dist.percDones()).append("</td></tr>")
						.append( NL );
			}

			sBHtmlEnd.append( "</table>" )
					.append( NL2 ).append("</body>" )
				.append( NL2 ).append("</html>");

		}
		for (int j = 0; j < distList.size(); j++) {
			System.out.println(distList.get(j).getCarrers());

		}
		try (BufferedWriter out = new BufferedWriter(new FileWriter(outputFile))) {
			out.write(sBHtml.toString());
			out.write(sBHtmlEnd.toString());
		} catch (Exception e) {
			return false;
		}

		return true;

	}

}
