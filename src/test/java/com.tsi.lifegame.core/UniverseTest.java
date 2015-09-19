package co.com.tsi.codingdojo.lifegame.core;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import co.com.tsi.codingdojo.lifegame.core.Universe;
import co.com.tsi.codingdojo.lifegame.core.Cell;

public class UniverseTest{

    boolean [][] initialPattern = new boolean [2][2];
    
    //Variable donde se guardara un patron inicial
    public void initialPatternInicialize(){
    
        for(int i = 0; i<2;i++){
            for(int j = 0; j<2; j++){
                initialPattern[i][j] = true;
            }
        }
    }
    
	//The universe of the Game of Life is an infinite two-dimensional orthogonal grid of square cells
	@Test	
	public void ExistUniverse(){
		Universe universe = new Universe();
		assertTrue(universe instanceof Universe);		
	}
			
    //The initial pattern constitutes the seed of the system. The first generation is created by applying the
    // above rules simultaneously to every cell in the seed—births and deaths occur simultaneously, and the discrete moment
    // at which this happens is sometimes called a tick (in other words, each generation is a pure function of the preceding one). 
    @Test
    public void ExistGridCells(){
    
        Universe universe = new Universe();
        initialPatternInicialize(); 
        universe.Seed(initialPattern);
        boolean cellState = universe.getStateCell(1,1);
        //Cell[][] gridOfCells = universe.getGridOfCells();
        //Cell cell = universe.getCell(1, 2);
        assertTrue(cellState);
    }
    
    //@Test
    public void TicksOfUniverse(){
    
        Universe universe = new Universe();
        initialPatternInicialize();
        universe.Seed(initialPattern);
        boolean cellState = universe.getStateCell(1,1);
        //int x = 3;
        //int y = 3;
        //universe.gridOfCellsInicialize(x,y);
        //Cell cell = universe.getCell(0,0);
        //universe.setNumberOfNeighboursAlive(cell, 0 , 0);
        //cell.Tick();
        assertFalse(cellState);
        
    }   
    
}
