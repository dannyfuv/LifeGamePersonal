package com.tsi.lifegame.core;

public class Universe{

        private int numGeneration = 1;
        private Cell [] [] gridOfCells;
        private int x;
        private int y;
        
        /**
            Constructor method
        */
        public Universe(){
        }
        
        /**
            returns state of the cell in the position x,y of the gridOfCells
        */
        public boolean getStateCell(int x, int y){
            
            return gridOfCells[x][y].getIsAlive();
        }
    
        /**
            assign the initial pattern of the gridOfCells
        */
        public void Seed(boolean [][] initialPattern){            
            if(initialPattern[0] != null){
                
                this.x = initialPattern.length; // rows
                this.y = initialPattern[0].length; //columns
                
                gridOfCells = new Cell [x] [y];
                
                for(int i = 0 ; i< x ; i++){
                    for(int j = 0 ; j< y ; j++ ){
                    
                    gridOfCells[i][j] = new Cell();
                    
                    if (! initialPattern[i][j]){
                        gridOfCells[i][j].Kill();
                    }
                }
            }
            }else{
                // retornar algun tipo de alerta
            }
          
        }
        
        /**
            turns an alive cell into a dead cell
        */
        private void killCell(int x, int y){
            
            gridOfCells[x][y].Kill();
        }
        
        /**
            return the dimension X of the gridOfCells
        */
        public int getDimensionX(){
            return this.x;
        }
        
        /**
            return the dimension Y of the gridOfCells
        */
        public int getDimensionY(){
            return this.y;
        }
                
        /**
            assign number of alive neighbours to a cell in the position x,y of the gridOfCells
        */
        private void setNumberOfNeighboursAlive(Cell cell, int x, int y){
                int numberOfNeighboursAlive = 0;
                try{
                        if(gridOfCells[x][y-1].getIsAlive()){
                            
                                numberOfNeighboursAlive++;
                        }
                    }catch(Exception e){
                            // No existe esa posición
                    }
                    
                try{
                        if(gridOfCells[x][y+1].getIsAlive()){
                            
                                numberOfNeighboursAlive++;
                        }
                    }catch(Exception e){
                            // No existe esa posición
                    }
                    
                try{
                        if(gridOfCells[x+1][y].getIsAlive()){
                            
                                numberOfNeighboursAlive++;
                        }
                    }catch(Exception e){
                            // No existe esa posición
                    }
                    
                try{
                        if(gridOfCells[x-1][y].getIsAlive()){
                            
                                numberOfNeighboursAlive++;
                        }
                    }catch(Exception e){
                            // No existe esa posición
                    }    
                    
                try{
                        if(gridOfCells[x-1][y+1].getIsAlive()){
                            
                                numberOfNeighboursAlive++;
                        }
                    }catch(Exception e){
                            // No existe esa posición
                    }
                    
                 try{
                        if(gridOfCells[x-1][y-1].getIsAlive()){
                            
                                numberOfNeighboursAlive++;
                        }
                    }catch(Exception e){
                            // No existe esa posición
                    }
                    
                 try{
                        if(gridOfCells[x+1][y-1].getIsAlive()){
                            
                                numberOfNeighboursAlive++;
                        }
                    }catch(Exception e){
                            // No existe esa posición
                    }
                    
                 try{
                        if(gridOfCells[x+1][y+1].getIsAlive()){
                            
                                numberOfNeighboursAlive++;
                        }
                    }catch(Exception e){
                            // No existe esa posición
                    }
                    
              cell.AssignNumberOfNeighboursAlive(numberOfNeighboursAlive);
        }
        
        /**
           Iterates the gridOfCells with the purpose of update the new state of each cell
        */
        public void Tick(){            
           for(int x = 0; x< gridOfCells.length ; x++){
                for(int y = 0; y< gridOfCells[x].length ; y++ ){
                    
                    setNumberOfNeighboursAlive(gridOfCells[x][y], x, y);
                    //gridOfCells[x][y].Transitions();
                }
           }
            
            for(int x = 0; x< gridOfCells.length ; x++){
                for(int y = 0; y< gridOfCells[x].length ; y++ ){
                    
                    //setNumberOfNeighboursAlive(gridOfCells[x][y], x, y);
                    gridOfCells[x][y].Tick();
                }
           }
            
           /* System.out.println("Generación numero: "+numGeneration);
            for(int x = 0; x< gridOfCells.length ; x++){
                for(int y = 0; y< gridOfCells[x].length ; y++ ){
                    
                    if(gridOfCells[x][y].getIsAlive()){
                        System.out.print("X ");
                    }else{
                        System.out.print(". ");
                    }
                }
                System.out.println("");
            }
            
            numGeneration++;
            try{
                Thread.sleep(1000);
            }catch(Exception e){
            
            }*/
            
        }       
}