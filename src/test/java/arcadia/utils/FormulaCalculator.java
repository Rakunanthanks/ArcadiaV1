package arcadia.utils;

import java.util.List;

public class FormulaCalculator {

    public Double getBundleDiameter(List<Double> wireDiameter){
        int numberOfWires = wireDiameter.size();
        Double bundleDiameter = 0.0;
        if(numberOfWires > 2){
            Double packingFactor = 0.0;
            if(numberOfWires >=3 && numberOfWires<=12){
                packingFactor= 1.25;
            }
            if(numberOfWires >=13 && numberOfWires<=18){
                packingFactor= 1.26;
            }
            if(numberOfWires >=19 && numberOfWires<=25){
                packingFactor= 1.27;
            }
            Double squareRoot = Math.sqrt(numberOfWires);
            Double averageDiameter = wireDiameter.stream()
                    .mapToDouble(d -> d)
                    .average()
                    .orElse(0.0);
            // Wire bundle diameter = packing factor * SQRT (wire count) * avg wire diameter)
            Double wireBundleDiameter = packingFactor * squareRoot * averageDiameter;
            bundleDiameter= Double.valueOf(Math.round(wireBundleDiameter));
        }

        if(numberOfWires > 1 && numberOfWires<3){
            bundleDiameter = Double.valueOf(wireDiameter.stream()
                    .mapToDouble(d -> d)
                    .sum());
        }
        if(numberOfWires > 0 && numberOfWires<2){
            bundleDiameter = Double.valueOf(wireDiameter.get(0));
        }
        return bundleDiameter;
    }

    public Double getReference(Double diameterScales, Double diameterAddon, Double baseValue){
        return Double.valueOf((Math.round((baseValue*diameterScales)+diameterAddon)));
    }

}
