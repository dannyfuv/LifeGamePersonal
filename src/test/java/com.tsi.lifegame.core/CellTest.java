package com.tsi.lifegame.core;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import com.tsi.lifegame.core.Cell;

public class CellTest{

        @Test 
        public void ExistCell(){
        
            Cell cell = new Cell();
            assertTrue(cell instanceof Cell);	
        }
        
        //each of which is in one of two possible states, alive or dead.
        @Test 
        public void CellIsAlive(){
            
            Cell cell = new Cell();
            assertTrue(cell.getIsAlive());
        }
        @Test
        public void CellIsDead() {
            Cell cell = new Cell();
            cell.Kill();
            assertFalse(cell.getIsAlive());		
            }
        // Transitions:
        //    Any live cell with fewer than two live neighbours dies, as if caused by under-population.
        @Test
        public void DiesByUnderPopulation() {
            Cell cell = new Cell();
            cell.AssignNumberOfNeighboursAlive(0);
            cell.Tick();
            //int numberOfNeighbours = cell.numberOfNeighbours;
            assertFalse(cell.getIsAlive());
            }
            
        //Any live cell with two or three live neighbours lives on to the next generation.
        @Test
        public void LivesNextGeneration(){	
            Cell cell = new Cell();
            cell.AssignNumberOfNeighboursAlive(2);
            cell.Tick();
            //int numberOfNeighbours = cell.numberOfNeighbours;
            //assertTrue(numberOfNeighbours >= 2 && numberOfNeighbours < 3);
             assertTrue(cell.getIsAlive());
             //assertTrue(cell.state == null);
        }
        
        //Any live cell with more than three live neighbours dies, as if by overcrowding.
        @Test
        public void DiesByOvercrowding(){	
            Cell cell = new Cell();
            cell.AssignNumberOfNeighboursAlive(4);
            cell.Tick();
            assertFalse(cell.getIsAlive());
            //int numberOfNeighbours = cell.numberOfNeighbours;
            //assertTrue(numberOfNeighbours > 3);
        }
        
        //Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.
        @Test
        public void BecomesLiveByReproduction(){		
            Cell cell = new Cell();
            cell.Kill();
            cell.AssignNumberOfNeighboursAlive(3);
            //int numberOfNeighbours = cell.numberOfNeighbours;
            //assertTrue(numberOfNeighbours == 3 && cell.state == "dead");
            cell.Tick();
            assertTrue(cell.getIsAlive());
        }
    
    }