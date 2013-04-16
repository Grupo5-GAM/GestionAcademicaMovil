package com.example.gestionacademicamovil.GAM.managers;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;

import com.example.gestionacademicamovil.GAM.model.Asignatura;
import com.example.gestionacademicamovil.GAM.model.Beca;
import com.example.gestionacademicamovil.GAM.model.Convalidacion;
import com.example.gestionacademicamovil.GAM.model.Nota;
import com.example.gestionacademicamovil.GAM.model.Traslado;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class CrearPDF
{
    private ArrayList datos;  
	
	public CrearPDF(ArrayList datos)
	{
		this.datos= datos;
	}
	public void descargarPDFBecas()
	{
		try 
	    { 
		 String stadoSD = Environment.getExternalStorageState();
		 if(stadoSD.equals(Environment.MEDIA_MOUNTED))
		 {
	        FileOutputStream file = new FileOutputStream(new File("/sdcard/download/Becas.pdf")); 

	        Document documento = new Document();	        
	        PdfWriter.getInstance(documento, file); 
	        PdfPTable tabla = new PdfPTable(1);
	        Paragraph Espacios= new Paragraph("\n");
	        PdfPCell celda=new PdfPCell(); 	       
	        PdfWriter.getInstance(documento,file); 
	        documento.open();
	        Paragraph titulo= new Paragraph("Becas \n",FontFactory.getFont("arial",12,BaseColor.WHITE));
	        titulo.setAlignment(1);
	        celda.setBackgroundColor(new BaseColor(880015));
            celda.addElement(titulo);
            tabla.addCell(celda);
            tabla.setWidthPercentage(100);
            documento.add(tabla);
            documento.add(Espacios);
            
            PdfPTable tablacabecera= new PdfPTable(2);
            PdfPCell tipo=new PdfPCell();
            Paragraph texttipo= new Paragraph("Tipo",FontFactory.getFont("arial",12,BaseColor.WHITE));
            texttipo.setAlignment(1);
            tipo.setBackgroundColor(BaseColor.BLACK);
            tipo.addElement(texttipo);
            tablacabecera.addCell(tipo); 
            
            PdfPCell estado =new PdfPCell();
            Paragraph textestado= new Paragraph("Estado",FontFactory.getFont("arial",12,BaseColor.WHITE));
            estado.setBackgroundColor(BaseColor.BLACK);
            textestado.setAlignment(1);
            estado.addElement(textestado);
            tablacabecera.addCell(estado);
            tablacabecera.setWidthPercentage(100);
            documento.add(tablacabecera);
            
            for(int i=0;i<datos.size();i++)
            {
                PdfPTable tablacuerpo= new PdfPTable(2);
                PdfPCell tipoaux=new PdfPCell();
                Paragraph texttipoaux= new Paragraph(((Beca)datos.get(i)).getTipo(),FontFactory.getFont("arial",10,BaseColor.BLACK));
                texttipoaux.setAlignment(1);
                tipoaux.setBackgroundColor(BaseColor.LIGHT_GRAY);
                tipoaux.addElement(texttipoaux);
                tablacuerpo.addCell(tipoaux);
                
                PdfPCell estadoaux =new PdfPCell();
                Paragraph textestadoaux= new Paragraph(((Beca)datos.get(i)).getEstado(),FontFactory.getFont("arial",10,BaseColor.BLACK));
                estadoaux.setBackgroundColor(BaseColor.LIGHT_GRAY);
                textestadoaux.setAlignment(1);
                estadoaux.addElement(textestadoaux);
                tablacuerpo.addCell(estadoaux);
                tablacuerpo.setWidthPercentage(100);               
                documento.add(tablacuerpo);
            }
            
            documento.add(Espacios);
            
	        documento.close(); 
	        file.close();
		 }
		 
	    } 
	    catch (Exception e) 
	    { 
	       //TextView tv = (TextView) findViewById(R.id.universidad); 
	       //tv.setText("Excepcion: "+e); 
	    } 
	}
	public void descargarPDFTraslados()
	{
		try 
	    { 
		 String stadoSD = Environment.getExternalStorageState();
		 if(stadoSD.equals(Environment.MEDIA_MOUNTED))
		 {
			FileOutputStream file = new FileOutputStream(new File("/sdcard/download/Traslados.pdf")); 

	        Document documento = new Document();	        
	        
	        PdfPTable tabla = new PdfPTable(1);
	        Paragraph Espacios= new Paragraph("\n");
	        PdfPCell celda=new PdfPCell(); 	        
	        PdfWriter.getInstance(documento,file); 
	        documento.open();
	        Paragraph titulo= new Paragraph("Traslados \n",FontFactory.getFont("arial",12,BaseColor.WHITE));
	        titulo.setAlignment(1);
	        celda.setBackgroundColor(new BaseColor(880015));
            celda.addElement(titulo);
            tabla.addCell(celda);
            tabla.setWidthPercentage(100);
            documento.add(tabla);
            documento.add(Espacios);
            
            PdfPTable tablacabecera= new PdfPTable(3);
            PdfPCell universidad=new PdfPCell();
            Paragraph textuniversidad= new Paragraph("Universidad",FontFactory.getFont("arial",12,BaseColor.WHITE));
            textuniversidad.setAlignment(1);
            universidad.setBackgroundColor(BaseColor.BLACK);
            universidad.addElement(textuniversidad);
            tablacabecera.addCell(universidad); 
            
            PdfPCell ciudad =new PdfPCell();
            Paragraph textciudad= new Paragraph("Ciudad",FontFactory.getFont("arial",12,BaseColor.WHITE));
            ciudad.setBackgroundColor(BaseColor.BLACK);
            textciudad.setAlignment(1);
            ciudad.addElement(textciudad);
            tablacabecera.addCell(ciudad);
            tablacabecera.setWidthPercentage(100);
            
            PdfPCell pais=new PdfPCell();
            Paragraph textpais= new Paragraph("País",FontFactory.getFont("arial",12,BaseColor.WHITE));
            pais.setBackgroundColor(BaseColor.BLACK);
            textpais.setAlignment(1);
            pais.addElement(textpais);
            tablacabecera.addCell(pais);
            tablacabecera.setWidthPercentage(100);
            
            documento.add(tablacabecera);
            
            for(int i=0;i<datos.size();i++)
            {
                PdfPTable tablacuerpo= new PdfPTable(3);
                PdfPCell universidadaux=new PdfPCell();
                Paragraph textuniversidadaux= new Paragraph(((Traslado)datos.get(i)).getUniversidad(),FontFactory.getFont("arial",10,BaseColor.BLACK));
                textuniversidadaux.setAlignment(1);
                universidadaux.setBackgroundColor(BaseColor.LIGHT_GRAY);
                universidadaux.addElement(textuniversidadaux);
                tablacuerpo.addCell(universidadaux);
                
                PdfPCell ciudadaux =new PdfPCell();
                Paragraph textciudadaux= new Paragraph(((Traslado)datos.get(i)).getCiudad(),FontFactory.getFont("arial",10,BaseColor.BLACK));
                ciudadaux.setBackgroundColor(BaseColor.LIGHT_GRAY);
                textciudadaux.setAlignment(1);
                ciudadaux.addElement(textciudadaux);
                tablacuerpo.addCell(ciudadaux);
                tablacuerpo.setWidthPercentage(100); 
                
                PdfPCell paisaux =new PdfPCell();
                Paragraph textpaisaux= new Paragraph(((Traslado)datos.get(i)).getPais(),FontFactory.getFont("arial",10,BaseColor.BLACK));
                paisaux.setBackgroundColor(BaseColor.LIGHT_GRAY);
                textpaisaux.setAlignment(1);
                paisaux.addElement(textpaisaux);
                tablacuerpo.addCell(paisaux);
                tablacuerpo.setWidthPercentage(100); 
                              
                documento.add(tablacuerpo);
            }
            
            documento.add(Espacios);
            documento.close(); 
            file.close();	        
	         
		 }
	 } 
	    catch (Exception e) 
	    { 
	       //TextView tv = (TextView) findViewById(R.id.universidad); 
	       //tv.setText("Excepcion: "+e); 
	    } 
	}
	public void descargarPDFConvalidaciones()
	{
		try 
	    { 
		 String stadoSD = Environment.getExternalStorageState();
		 if(stadoSD.equals(Environment.MEDIA_MOUNTED))
		 {
	        FileOutputStream file = new FileOutputStream(new File("/sdcard/download/Convalidaciones.pdf")); 

	        Document documento = new Document();	        
	        PdfWriter.getInstance(documento, file); 
	        PdfPTable tabla = new PdfPTable(1);
	        Paragraph Espacios= new Paragraph("\n");
	        PdfPCell celda=new PdfPCell(); 	       
	        PdfWriter.getInstance(documento,file); 
	        documento.open();
	        Paragraph titulo= new Paragraph("Convalidaciones \n",FontFactory.getFont("arial",12,BaseColor.WHITE));
	        titulo.setAlignment(1);
	        celda.setBackgroundColor(new BaseColor(880015));
            celda.addElement(titulo);
            tabla.addCell(celda);
            tabla.setWidthPercentage(100);
            documento.add(tabla);
            documento.add(Espacios);
            
            PdfPTable tablacabecera= new PdfPTable(5);
            PdfPCell asignatura=new PdfPCell();
            Paragraph textasignatura= new Paragraph("Asignatura",FontFactory.getFont("arial",12,BaseColor.WHITE));
            textasignatura.setAlignment(1);
            asignatura.setBackgroundColor(BaseColor.BLACK);
            asignatura.addElement(textasignatura);
            tablacabecera.addCell(asignatura); 
            
            PdfPCell asignaturaant =new PdfPCell();
            Paragraph textasignaturaant= new Paragraph("Asignatura Antigua",FontFactory.getFont("arial",12,BaseColor.WHITE));
            asignaturaant.setBackgroundColor(BaseColor.BLACK);
            textasignaturaant.setAlignment(1);
            asignaturaant.addElement(textasignaturaant);
            tablacabecera.addCell(asignaturaant);
            tablacabecera.setWidthPercentage(100);
            documento.add(tablacabecera);
            
            PdfPCell creditos =new PdfPCell();
            Paragraph textcreditos= new Paragraph("Créditos",FontFactory.getFont("arial",12,BaseColor.WHITE));
            creditos.setBackgroundColor(BaseColor.BLACK);
            textcreditos.setAlignment(1);
            creditos.addElement(textcreditos);
            tablacabecera.addCell(creditos);
            tablacabecera.setWidthPercentage(100);
            documento.add(tablacabecera);
            
            PdfPCell tipo =new PdfPCell();
            Paragraph texttipo= new Paragraph("Tipo",FontFactory.getFont("arial",12,BaseColor.WHITE));
            tipo.setBackgroundColor(BaseColor.BLACK);
            texttipo.setAlignment(1);
            tipo.addElement(texttipo);
            tablacabecera.addCell(tipo);
            tablacabecera.setWidthPercentage(100);
            documento.add(tablacabecera);
            
            PdfPCell nota =new PdfPCell();
            Paragraph textnota= new Paragraph("Nota",FontFactory.getFont("arial",12,BaseColor.WHITE));
            nota.setBackgroundColor(BaseColor.BLACK);
            textnota.setAlignment(1);
            nota.addElement(textnota);
            tablacabecera.addCell(nota);
            tablacabecera.setWidthPercentage(100);
            documento.add(tablacabecera);
            
            for(int i=0;i<datos.size();i++)
            {
                PdfPTable tablacuerpo= new PdfPTable(5);
                PdfPCell asignaturaaux=new PdfPCell();
                Paragraph textasignaturaaux= new Paragraph(((Convalidacion)datos.get(i)).getAsignatura(),FontFactory.getFont("arial",10,BaseColor.BLACK));
                textasignaturaaux.setAlignment(1);
                asignaturaaux.setBackgroundColor(BaseColor.LIGHT_GRAY);
                asignaturaaux.addElement(textasignaturaaux);
                tablacuerpo.addCell(asignaturaaux);
                
                PdfPCell asignaturaantaux =new PdfPCell();
                Paragraph textasignaturaantaux= new Paragraph(((Convalidacion)datos.get(i)).getAsignaturaAntigua(),FontFactory.getFont("arial",10,BaseColor.BLACK));
                asignaturaantaux.setBackgroundColor(BaseColor.LIGHT_GRAY);
                textasignaturaantaux.setAlignment(1);
                asignaturaantaux.addElement(textasignaturaantaux);
                tablacuerpo.addCell(asignaturaantaux);
                tablacuerpo.setWidthPercentage(100); 
                
                PdfPCell creditosaux =new PdfPCell();
                Paragraph textcreditosaux= new Paragraph(String.valueOf(((Convalidacion)datos.get(i)).getCreditos()),FontFactory.getFont("arial",10,BaseColor.BLACK));
                creditosaux.setBackgroundColor(BaseColor.LIGHT_GRAY);
                textcreditosaux.setAlignment(1);
                creditosaux.addElement(textcreditosaux);
                tablacuerpo.addCell(creditosaux);
                tablacuerpo.setWidthPercentage(100);  
                
                PdfPCell tipoaux =new PdfPCell();
                Paragraph texttipoaux= new Paragraph(((Convalidacion)datos.get(i)).getTipo(),FontFactory.getFont("arial",10,BaseColor.BLACK));
                tipoaux.setBackgroundColor(BaseColor.LIGHT_GRAY);
                texttipoaux.setAlignment(1);
                tipoaux.addElement(texttipoaux);
                tablacuerpo.addCell(tipoaux);
                tablacuerpo.setWidthPercentage(100); 
                
                PdfPCell notaaux =new PdfPCell();
                Paragraph textnotaaux= new Paragraph(String.valueOf(((Convalidacion)datos.get(i)).getNota()),FontFactory.getFont("arial",10,BaseColor.BLACK));
                notaaux.setBackgroundColor(BaseColor.LIGHT_GRAY);
                textnotaaux.setAlignment(1);
                notaaux.addElement(textnotaaux);
                tablacuerpo.addCell(notaaux);
                tablacuerpo.setWidthPercentage(100);  
                
                
                documento.add(tablacuerpo);
            }
            
            documento.add(Espacios);
            
	        documento.close(); 
	        file.close();
		 }
		 
	    } 
	    catch (Exception e) 
	    { 
	       //TextView tv = (TextView) findViewById(R.id.universidad); 
	       //tv.setText("Excepcion: "+e); 
	    } 
	}
	public void descargarPDFNotas()
	{
		try 
	    { 
		 String stadoSD = Environment.getExternalStorageState();
		 if(stadoSD.equals(Environment.MEDIA_MOUNTED))
		 {
	        FileOutputStream file = new FileOutputStream(new File("/sdcard/download/Notas.pdf")); 

	        Document documento = new Document();	        
	        PdfWriter.getInstance(documento, file); 
	        PdfPTable tabla = new PdfPTable(1);
	        Paragraph Espacios= new Paragraph("\n");
	        PdfPCell celda=new PdfPCell(); 	       
	        PdfWriter.getInstance(documento,file); 
	        documento.open();
	        Paragraph titulo= new Paragraph("Notas \n",FontFactory.getFont("arial",12,BaseColor.WHITE));
	        titulo.setAlignment(1);
	        celda.setBackgroundColor(new BaseColor(880015));
            celda.addElement(titulo);
            tabla.addCell(celda);
            tabla.setWidthPercentage(100);
            documento.add(tabla);
            documento.add(Espacios);
            
            PdfPTable tablacabecera= new PdfPTable(6);
            PdfPCell cuatrimestre =new PdfPCell();
            Paragraph textcuatrimestre= new Paragraph("Cuatrimestre",FontFactory.getFont("arial",12,BaseColor.WHITE));
            cuatrimestre.setBackgroundColor(BaseColor.BLACK);
            textcuatrimestre.setAlignment(1);
            cuatrimestre.addElement(textcuatrimestre);
            tablacabecera.addCell(cuatrimestre);
            tablacabecera.setWidthPercentage(100);
            documento.add(tablacabecera);
            
            PdfPCell asignatura=new PdfPCell();
            Paragraph textasignatura= new Paragraph("Asignatura",FontFactory.getFont("arial",12,BaseColor.WHITE));
            textasignatura.setAlignment(1);
            asignatura.setBackgroundColor(BaseColor.BLACK);
            asignatura.addElement(textasignatura);
            tablacabecera.addCell(asignatura); 
            
            PdfPCell creditos =new PdfPCell();
            Paragraph textcreditos= new Paragraph("Créditos",FontFactory.getFont("arial",12,BaseColor.WHITE));
            creditos.setBackgroundColor(BaseColor.BLACK);
            textcreditos.setAlignment(1);
            creditos.addElement(textcreditos);
            tablacabecera.addCell(creditos);
            tablacabecera.setWidthPercentage(100);
            documento.add(tablacabecera);
            
            PdfPCell nota =new PdfPCell();
            Paragraph textnota= new Paragraph("Nota",FontFactory.getFont("arial",12,BaseColor.WHITE));
            nota.setBackgroundColor(BaseColor.BLACK);
            textnota.setAlignment(1);
            nota.addElement(textnota);
            tablacabecera.addCell(nota);
            tablacabecera.setWidthPercentage(100);
            documento.add(tablacabecera);
            
            PdfPCell definitiva =new PdfPCell();
            Paragraph textdefinitiva= new Paragraph("Definitiva",FontFactory.getFont("arial",12,BaseColor.WHITE));
            definitiva.setBackgroundColor(BaseColor.BLACK);
            textdefinitiva.setAlignment(1);
            definitiva.addElement(textdefinitiva);
            tablacabecera.addCell(definitiva);
            tablacabecera.setWidthPercentage(100);
            documento.add(tablacabecera);
            
            PdfPCell revision =new PdfPCell();
            Paragraph textrevision= new Paragraph("Revisión",FontFactory.getFont("arial",12,BaseColor.WHITE));
            revision.setBackgroundColor(BaseColor.BLACK);
            textrevision.setAlignment(1);
            revision.addElement(textrevision);
            tablacabecera.addCell(revision);
            tablacabecera.setWidthPercentage(100);
            documento.add(tablacabecera);
            
            for(int i=0;i<datos.size();i++)
            {
                PdfPTable tablacuerpo= new PdfPTable(6);
                
                PdfPCell cuatrimestreaux=new PdfPCell();
                Paragraph textcuatrimestreaux= new Paragraph(String.valueOf(((Nota)datos.get(i)).getCuatrimestre()),FontFactory.getFont("arial",10,BaseColor.BLACK));
                textcuatrimestreaux.setAlignment(1);
                cuatrimestreaux.setBackgroundColor(BaseColor.LIGHT_GRAY);
                cuatrimestreaux.addElement(textcuatrimestreaux);
                tablacuerpo.addCell(cuatrimestreaux);
                
                PdfPCell asignaturaaux=new PdfPCell();
                Paragraph textasignaturaaux= new Paragraph(((Nota)datos.get(i)).getAsignatura(),FontFactory.getFont("arial",10,BaseColor.BLACK));
                textasignaturaaux.setAlignment(1);
                asignaturaaux.setBackgroundColor(BaseColor.LIGHT_GRAY);
                asignaturaaux.addElement(textasignaturaaux);
                tablacuerpo.addCell(asignaturaaux);
                
                PdfPCell creditosaux =new PdfPCell();
                Paragraph textcreditosaux= new Paragraph(String.valueOf(((Nota)datos.get(i)).getCreditos()),FontFactory.getFont("arial",10,BaseColor.BLACK));
                creditosaux.setBackgroundColor(BaseColor.LIGHT_GRAY);
                textcreditosaux.setAlignment(1);
                creditosaux.addElement(textcreditosaux);
                tablacuerpo.addCell(creditosaux);
                tablacuerpo.setWidthPercentage(100); 
                
                PdfPCell notaaux =new PdfPCell();
                Paragraph textnotaaux= new Paragraph(String.valueOf(((Nota)datos.get(i)).getNota()),FontFactory.getFont("arial",10,BaseColor.BLACK));
                notaaux.setBackgroundColor(BaseColor.LIGHT_GRAY);
                textnotaaux.setAlignment(1);
                notaaux.addElement(textnotaaux);
                tablacuerpo.addCell(notaaux);
                tablacuerpo.setWidthPercentage(100);  
                
                PdfPCell definitivaaux =new PdfPCell();
                Paragraph textdefinitivaaux= new Paragraph(String.valueOf(((Nota)datos.get(i)).isDefinitiva()),FontFactory.getFont("arial",10,BaseColor.BLACK));
                definitivaaux.setBackgroundColor(BaseColor.LIGHT_GRAY);
                textdefinitivaaux.setAlignment(1);
                definitivaaux.addElement(textdefinitivaaux);
                tablacuerpo.addCell(definitivaaux);
                tablacuerpo.setWidthPercentage(100); 
                
                PdfPCell revisionaux =new PdfPCell();
                Paragraph textrevisionaux= new Paragraph(String.valueOf(((Nota)datos.get(i)).getRevision()),FontFactory.getFont("arial",10,BaseColor.BLACK));
                revisionaux.setBackgroundColor(BaseColor.LIGHT_GRAY);
                textrevisionaux.setAlignment(1);
                revisionaux.addElement(textrevisionaux);
                tablacuerpo.addCell(revisionaux);
                tablacuerpo.setWidthPercentage(100);  
                
                
                documento.add(tablacuerpo);
            }
            
            documento.add(Espacios);
            
	        documento.close(); 
	        file.close();
		 }
		 
	    } 
	    catch (Exception e) 
	    { 
	       //TextView tv = (TextView) findViewById(R.id.universidad); 
	       //tv.setText("Excepcion: "+e); 
	    } 
	}
	public void descargarPDFAsignaturas()
	{
		try 
	    { 
		 String stadoSD = Environment.getExternalStorageState();
		 if(stadoSD.equals(Environment.MEDIA_MOUNTED))
		 {
	        FileOutputStream file = new FileOutputStream(new File("/sdcard/download/Asignaturas.pdf")); 

	        Document documento = new Document();	        
	        PdfWriter.getInstance(documento, file); 
	        PdfPTable tabla = new PdfPTable(1);
	        Paragraph Espacios= new Paragraph("\n");
	        PdfPCell celda=new PdfPCell(); 	       
	        PdfWriter.getInstance(documento,file); 
	        documento.open();
	        Paragraph titulo= new Paragraph("Asignaturas \n",FontFactory.getFont("arial",12,BaseColor.WHITE));
	        titulo.setAlignment(1);
	        celda.setBackgroundColor(new BaseColor(880015));
            celda.addElement(titulo);
            tabla.addCell(celda);
            tabla.setWidthPercentage(100);
            documento.add(tabla);
            documento.add(Espacios);
            
            PdfPTable tablacabecera= new PdfPTable(5);
            PdfPCell grado=new PdfPCell();
            Paragraph textgrado= new Paragraph("Grado",FontFactory.getFont("arial",12,BaseColor.WHITE));
            textgrado.setAlignment(1);
            grado.setBackgroundColor(BaseColor.BLACK);
            grado.addElement(textgrado);
            tablacabecera.addCell(grado); 
            
            PdfPCell nombre =new PdfPCell();
            Paragraph textnombre= new Paragraph("Nombre",FontFactory.getFont("arial",12,BaseColor.WHITE));
            nombre.setBackgroundColor(BaseColor.BLACK);
            textnombre.setAlignment(1);
            nombre.addElement(textnombre);
            tablacabecera.addCell(nombre);
            tablacabecera.setWidthPercentage(100);
            documento.add(tablacabecera);
            
            PdfPCell creditos =new PdfPCell();
            Paragraph textcreditos= new Paragraph("Créditos",FontFactory.getFont("arial",12,BaseColor.WHITE));
            creditos.setBackgroundColor(BaseColor.BLACK);
            textcreditos.setAlignment(1);
            creditos.addElement(textcreditos);
            tablacabecera.addCell(creditos);
            tablacabecera.setWidthPercentage(100);
            documento.add(tablacabecera);
            
            PdfPCell profesor =new PdfPCell();
            Paragraph textprofesor= new Paragraph("Profesor",FontFactory.getFont("arial",12,BaseColor.WHITE));
            profesor.setBackgroundColor(BaseColor.BLACK);
            textprofesor.setAlignment(1);
            profesor.addElement(textprofesor);
            tablacabecera.addCell(profesor);
            tablacabecera.setWidthPercentage(100);
            documento.add(tablacabecera);
            
            PdfPCell guia =new PdfPCell();
            Paragraph textguia= new Paragraph("Guia",FontFactory.getFont("arial",12,BaseColor.WHITE));
            guia.setBackgroundColor(BaseColor.BLACK);
            textguia.setAlignment(1);
            guia.addElement(textguia);
            tablacabecera.addCell(guia);
            tablacabecera.setWidthPercentage(100);
            documento.add(tablacabecera);
            
            for(int i=0;i<datos.size();i++)
            {
                PdfPTable tablacuerpo= new PdfPTable(5);
                PdfPCell gradoaux=new PdfPCell();
                Paragraph textgradoaux= new Paragraph(((Asignatura)datos.get(i)).getGrado(),FontFactory.getFont("arial",10,BaseColor.BLACK));
                textgradoaux.setAlignment(1);
                gradoaux.setBackgroundColor(BaseColor.LIGHT_GRAY);
                gradoaux.addElement(textgradoaux);
                tablacuerpo.addCell(gradoaux);
                
                PdfPCell nombreaux =new PdfPCell();
                Paragraph textnombreaux= new Paragraph(((Asignatura)datos.get(i)).getNombre(),FontFactory.getFont("arial",10,BaseColor.BLACK));
                nombreaux.setBackgroundColor(BaseColor.LIGHT_GRAY);
                textnombreaux.setAlignment(1);
                nombreaux.addElement(textnombreaux);
                tablacuerpo.addCell(nombreaux);
                tablacuerpo.setWidthPercentage(100); 
                
                PdfPCell creditosaux =new PdfPCell();
                Paragraph textcreditosaux= new Paragraph(String.valueOf(((Asignatura)datos.get(i)).getCreditos()),FontFactory.getFont("arial",10,BaseColor.BLACK));
                creditosaux.setBackgroundColor(BaseColor.LIGHT_GRAY);
                textcreditosaux.setAlignment(1);
                creditosaux.addElement(textcreditosaux);
                tablacuerpo.addCell(creditosaux);
                tablacuerpo.setWidthPercentage(100);  
                
                PdfPCell profesoraux =new PdfPCell();
                Paragraph textprofesoraux= new Paragraph(((Asignatura)datos.get(i)).getProfesor(),FontFactory.getFont("arial",10,BaseColor.BLACK));
                profesoraux.setBackgroundColor(BaseColor.LIGHT_GRAY);
                textprofesoraux.setAlignment(1);
                profesoraux.addElement(textprofesoraux);
                tablacuerpo.addCell(profesoraux);
                tablacuerpo.setWidthPercentage(100); 
                
                PdfPCell guiaaux =new PdfPCell();
                Paragraph textguiaaux= new Paragraph(String.valueOf(((Asignatura)datos.get(i)).getGuia()),FontFactory.getFont("arial",10,BaseColor.BLACK));
                guiaaux.setBackgroundColor(BaseColor.LIGHT_GRAY);
                textguiaaux.setAlignment(1);
                guiaaux.addElement(textguiaaux);
                tablacuerpo.addCell(guiaaux);
                tablacuerpo.setWidthPercentage(100);  
                
                
                documento.add(tablacuerpo);
            }
            
            documento.add(Espacios);
            
	        documento.close(); 
	        file.close();
		 }
		 
	    } 
	    catch (Exception e) 
	    { 
	       //TextView tv = (TextView) findViewById(R.id.universidad); 
	       //tv.setText("Excepcion: "+e); 
	    } 
	}

}
