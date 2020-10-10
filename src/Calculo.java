
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Vinicius
 */
public interface Calculo extends Operacao {
    public double RESULTADO = 0;
    
    public double calcula( List<Double> valores, List<Integer> operacao );
    public int coletaOperacao( List<Integer> operacao );
    public void coletaValores( List<Double> valores );
    public void setValorA( double valor );
    public void setValorB( double valor );
    public double getValorA( );
    public double getValorB( );
    public void setOperacao( int operacao );
    public void setValor( double valor );
}
