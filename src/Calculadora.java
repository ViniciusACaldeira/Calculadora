import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Vinicius
 */
public class Calculadora implements Calculo {
    int posicaoValores = 0;
    int posicaoOperacao = 0;
    double valorA = 0.0;
    double valorB = 0.0;
    double resultado = 0.0;
    String msg = "";
    String calculo = "";
    List<Double> valores = new ArrayList<Double>( );;
    List<Integer> operacao = new ArrayList<Integer>();;

    public String coletaMsg( )
    {
        return calculo;
    }
    
    @Override
    public int coletaOperacao( List<Integer> operacao )
    {
        return operacao.get( posicaoOperacao++ );
    }
    
    @Override
    public void coletaValores( List<Double> valores )
    {
        try
        {
            setValorA( posicaoValores == 0 ? valores.get( posicaoValores ) : resultado );
            System.out.println("posicaoValores = " + posicaoValores );
            setValorB( valores.get( ++posicaoValores ) );  
        }
        catch( Exception e )
        {
             setValorB( 0 ); 
        }
    }
    
    public void montaCalculo( String valor)
    {
        calculo = calculo.concat( valor );
    }
    
    public void ajustaCalculo( String calc )
    {
        calculo = calc;
    }
    @Override
    public double calcula( List<Double> valores, List<Integer> operacao )
    {
        ajustaArrays( );
        
        for( int i = 0; i < operacao.size( ); i++ )
        {
            coletaValores( valores );
            switch( coletaOperacao( operacao ) )
            {
                case 1:
                    resultado = getValorA( ) + getValorB( );
                    System.out.println( getValorA( ) + sSOMA + getValorB( ) + "=" + resultado );
                    break;
                case 2:
                    resultado = getValorA( ) - getValorB( );
                    System.out.println( getValorA( ) + sSUBTRACAO + getValorB( ) + "=" + resultado );
                    break;
                case 3:
                    resultado = getValorA( ) * getValorB( );
                    System.out.println( getValorA( ) + sMULTIPLICACAO + getValorB( ) + "=" + resultado );
                    break;
                case 4:
                    resultado = (getValorA( ) == 0 && getValorB( ) == 0 ? 0 : getValorA( ) / getValorB( ));
                    System.out.println( getValorA( ) + sDIVISAO + getValorB( ) + "=" + resultado );
                    break;
            }
        }
        
        finalizaCalculo( resultado );
        
        return resultado;
    }
    
    private void ajustaArrays( )
    {
        valores.clear( );
        operacao.clear( );
        
        Pattern pattern = Pattern.compile("\\D+|\\d*\\.?\\d+");
        Matcher matcher = pattern.matcher(calculo.trim( ));
        while (matcher.find()){
            if( validaOperacao( matcher.group(0) ) == 0 )
                valores.add( Double.valueOf( matcher.group(0) ) );
            else
                operacao.add( validaOperacao( matcher.group(0) ) );
        }
        
        System.out.println("Tamanhao valores = " + valores.size( ));

        System.out.println("Tamanhao operacoes = " + operacao.size( ));
    }
    
    private int validaOperacao( String operacao )
    {
        int op = 0;
        switch( operacao )
        {
            case sSOMA:
                op = SOMA;
                break;
            case sSUBTRACAO:
                op = SUBTRACAO;
                break;
            case sMULTIPLICACAO:
                op = MULTIPLICACAO;
                break;
            case sDIVISAO:
                op = DIVISAO;
                break;   
        }
        return op;
    }
    private void finalizaCalculo( double resultado )
    {
        valores.clear( );
        operacao.clear( );
        msg = Double.toString( resultado );
        calculo = Double.toString( resultado );
        posicaoValores = 0;
        posicaoOperacao = 0;
    }

    @Override
    public void setValorA(double valor) {
        valorA = valor;
    }

    @Override
    public void setValorB(double valor) {
        valorB = valor;
    }

    @Override
    public double getValorA() {
        return valorA;
    }

    @Override
    public double getValorB() {
        return valorB;
    }

    @Override
    public void setOperacao(int valor ) {
        operacao.add( valor );
    }

    @Override
    public void setValor(double valor) {
        if( operacao.size( ) == valores.size( ) );
    }
}