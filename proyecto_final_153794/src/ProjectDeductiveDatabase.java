/****
 Proyecto de Carlos Eduardo Castelán Vázquez ID:153794
 ***/

import java.util.List;
import java.util.StringTokenizer;
import java.util.Vector;

import it.unical.mat.dlv.program.Term;
import it.unical.mat.wrapper.FactResult;



public class ProjectDeductiveDatabase
{
    static DeductiveDatabase database;
    static Vector<FactResult>  answerSet;



    public static Vector<Dato> getDatos(Vector<FactResult>  answerSet)
    {
        Vector<Dato> datos;
        Dato dato;
        FactResult factResult;
        int i;
        int j;
        List<Term> lista;
        String predicate;
        StringTokenizer tokenizer;
        //
        datos = new Vector<Dato>();
        i = 0;
        while(i < answerSet.size())
        {
            factResult = answerSet.get(i);
            lista = factResult.attributes();
            if(lista.size() == 0)
                predicate = factResult.toString();
            else
            {
                tokenizer = new StringTokenizer(factResult.toString(), "(");
                predicate = tokenizer.nextToken();
            }//end else
            dato = new Dato(predicate);
            if(lista.size() != 0)
            {
                j = 0;
                while(j < lista.size())
                {
                    dato.addArgument(lista.get(j).toString());
                    j = j + 1;
                }//end while
            }//end if
            datos.add(dato);
            i = i + 1;
        }//end while

        return datos;
    }//end getDatos

    //Metodo para cargar el archivo de dlv
    public static void cargarArchivos(){
        database = new DeductiveDatabase("./dlv.bin");
        database.load("./guessFacts.txt");
        database.load("./guessRules.txt");
        answerSet = database.getAnswerSet();
    }

//metodo para obtener el personaje  del answerset
    public static String getCharacter(String opcion){
        StringBuilder sb = new StringBuilder();
        Vector<Dato> datos;
        cargarArchivos();
        datos = getDatos(answerSet);

        switch(opcion){
            case "SiNoSi":
                for(Dato dato:datos){
                    if(dato.getPredicate().equals("britishDeadManGlasses")){
                        sb.append("Su personaje es " +dato.getArgument(0)+ "\n");
                    }
                }
                break;
            case "SiNoNo":
                for(Dato dato:datos){
                    if(dato.getPredicate().equals("britishDeadManNoGlasses")){
                        sb.append("Su personaje es " +dato.getArgument(0)+ "\n");
                    }
                }
                break;
            case "SiSiSi":
                for(Dato dato:datos){
                    if(dato.getPredicate().equals("britishAliveManGlasses")){
                        sb.append("Su personaje es " +dato.getArgument(0)+ "\n");
                    }
                }
                break;
            case "SiSiNo":
                for(Dato dato:datos){
                    if(dato.getPredicate().equals("britishAliveManNoGlasses")){
                        sb.append("Su personaje es " +dato.getArgument(0)+ "\n");
                    }
                }
                break;
            case "NoNoNo":
                for(Dato dato:datos){
                    if(dato.getPredicate().equals("mexicanDeadWoman")){
                        sb.append("Su personaje es " +dato.getArgument(0)+ "\n");
                    }
                }
                break;
            case "NoNoSi":
                for(Dato dato:datos){
                    if(dato.getPredicate().equals("americanDeadWoman")){
                        sb.append("Su personaje es " +dato.getArgument(0)+ "\n");
                    }
                }
                break;
            case "NoSiSi":
                for(Dato dato:datos){
                    if(dato.getPredicate().equals("americanAliveWoman")){
                        sb.append("Su personaje es " +dato.getArgument(0)+ "\n");
                    }
                }
                break;
            case "NoSiNo":
                for(Dato dato:datos){
                    if(dato.getPredicate().equals("japaneseAliveWoman")){
                        sb.append("Su personaje es " +dato.getArgument(0)+ "\n");
                    }
                }
                break;

        }



        return sb.toString();
    }

}//end ProjectDeductiveDatabase


