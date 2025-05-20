// enum type for Vehicle
enum VehicleSize {
    Motorcycle,
    Compact,
    Large,
}

abstract class Vehicle {
    // Write your code here
    abstract VehicleSize size();
}

class Motorcycle extends Vehicle {
    // Write your code here
    @Override
    VehicleSize size() {
        return VehicleSize.Motorcycle;
    }
}

class Car extends Vehicle {
    // Write your code here
    @Override
    VehicleSize size() {
        return VehicleSize.Compact;
    }
}

class Bus extends Vehicle {
    // Write your code here
    @Override
    VehicleSize size() {
        return VehicleSize.Large;
    }
}

class ParkingSpot {
    int level, row, spotNumber;
    VehicleSize spotSize;
    Vehicle currentVehicle;

    public ParkingSpot(int level, int row, int spotNumber, VehicleSize size) {
        this.level = level;
        this.row = row;
        this.spotNumber = spotNumber;
        this.spotSize = size;
    }

    public boolean park(Vehicle v) {
        if (!isAvailable()) return false;
        this.currentVehicle = v;
        return true;
    }

    public void unPark() {
        this.currentVehicle = null;
    }

    public boolean isAvailable() {
        return currentVehicle == null;
    }
}

class Level {
    int levelNumber, numRows, spotsPerRow;
    ParkingSpot[][] spots;

    public Level(int levelNumber, int numRows, int spotsPerRow) {
        this.levelNumber = levelNumber;
        this.numRows = numRows;
        this.spotsPerRow = spotsPerRow;
        this.spots = new ParkingSpot[numRows][spotsPerRow];
        initSpots();
    }

    private void initSpots() {
        for (int r = 0; r < numRows; r++) {
            for (int s = 0; s < spotsPerRow; s++) {
                VehicleSize size;
                if (s < spotsPerRow / 4) size = VehicleSize.Motorcycle;
                else if (s < spotsPerRow * 3 / 4) size = VehicleSize.Compact;
                else size = VehicleSize.Large;
                spots[r][s] = new ParkingSpot(levelNumber, r, s, size);
            }
        }
    }

    public boolean parkVehicle(Vehicle v) {
        if (v instanceof Bus) {
            for (int r = 0; r < numRows; r++) {
                for (int s = spotsPerRow/4*3; s <= spotsPerRow - 5; s++) {
                    boolean canPark = true;
                    for (int k = 0; k < 5; k++) {
                        if ( !spots[r][s + k].isAvailable()) {
                            canPark = false;
                            break;
                        }
                    }
                    if (canPark) {
                        for (int k = 0; k < 5; k++) {
                            spots[r][s + k].park(v);
                        }
                        return true;
                    }
                }
            }
        } else if (v instanceof Car) {
            for (int r = 0; r < numRows; r++) {
                for (int s = spotsPerRow/4; s < spotsPerRow; s++) {
                    if (spots[r][s].isAvailable()) {
                        spots[r][s].park(v);
                        return true;
                    }
                }
            }
        } else {
            for (int r = 0; r < numRows; r++) {
                for (int s = 0; s < spotsPerRow; s++) {
                    if (spots[r][s].isAvailable()) {
                        spots[r][s].park(v);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public void unParkVehicle(Vehicle v) {
        for (int r = 0; r < numRows; r++) {
            for (int s = 0; s < spotsPerRow; s++) {
                if (spots[r][s].currentVehicle != null && spots[r][s].currentVehicle.equals(v)) {
                    spots[r][s].unPark();
                }
            }
        }
    }
}

public class ParkingLot {
    private List<Level> levels;

    public ParkingLot(int n, int num_rows, int spots_per_row) {
        levels = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            levels.add(new Level(i, num_rows, spots_per_row));
        }
    }

    public boolean parkVehicle(Vehicle vehicle) {
        for (Level level : levels) {
            if (level.parkVehicle(vehicle)) return true;
        }
        return false;
    }

    public void unParkVehicle(Vehicle vehicle) {
        for (Level level : levels) {
            level.unParkVehicle(vehicle);
        }
    }
}