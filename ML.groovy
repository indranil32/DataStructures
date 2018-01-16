// test data set
List<Double[]> featureVectorList = new ArrayList<Double[]>();

Double[] set1 = new Double[5]
set1[0] = 1
set1[1] = 90 // size increase price increase
set1[2] = 1 // number of rooms increase and size increase, price increase
set1[3] = 2 // age of house increase price decrease
set1[4] = 249 // label price in Euro K
featureVectorList.add(set1)

Double[] set2 = new Double[5]
set2[0] = 1
set2[1] = 101 
set2[2] = 1 
set2[3] = 3 
set2[4] = 328 // label
featureVectorList.add(set2)


Double[] set7 = new Double[5]
set7[0] = 1
set7[1] = 3990 
set7[2] = 30 
set7[3] = 12 
set7[4] = 13500 // label
featureVectorList.add(set7)

Double[] set9 = new Double[5]
set9[0] = 1
set9[1] = 191 
set9[2] = 2 
set9[3] = 3 
set9[4] = 550 // label
featureVectorList.add(set9)


Double[] set8 = new Double[5]
set8[0] = 1
set8[1] = 380 
set8[2] = 3 
set8[3] = 3 
set8[4] = 790 // label
featureVectorList.add(set8)



Double[] set3 = new Double[5]
set3[0] = 1
set3[1] = 1330 
set3[2] = 11 
set3[3] = 12 
set3[4] = 4500 // label
featureVectorList.add(set3)



// to be predicted
Double[] data = new Double[5]
data[0] = 1
data[1] = 500 
data[2] = 4 
data[3] = 12 
data[4] = 0 // doesn't have a label

Double[] data2 = new Double[5]
data2[0] = 1
data2[1] = 2660 
data2[2] = 22 
data2[3] = 12 
data2[4] = 0 // doesn't have a label



// initial theta vector, starting value
Double[] thetaVector = new Double [3];
thetaVector[0] = new Double(1.0f)
thetaVector[1] = new Double(1.0f)
thetaVector[2] = new Double(1.0f)

// gradient dissent
//List<Double[]> thetaVectorList = new ArrayList<Double[]>();

//Double[] thetaVector0 = new Double [3];
//thetaVector0[0] = new Double(3.004579f)
//thetaVector0[1] = new Double(3.286822f)
//thetaVector0[2] = new Double(3.0f)
//thetaVectorList.add(thetaVector0)

// considered best value
Double[] thetaVector1 = new Double [3];
thetaVector1[0] = new Double(1.004579f)
thetaVector1[1] = new Double(3.486822f)
thetaVector1[2] = new Double(2.713178f)
//thetaVectorList.add(thetaVector1)

//Double[] thetaVector2 = new Double [3];
//thetaVector2[0] = new Double(2.004579f)
//thetaVector2[1] = new Double(4.286822f)
//thetaVector2[2] = new Double(2.5f)
//thetaVectorList.add(thetaVector2)

public class LinearRegressionTargetFunction {
    private final Double[] thetaVector;
    
    public LinearRegressionTargetFunction(Double[] thetaVector) {
        this.thetaVector = Arrays.copyOf(thetaVector, thetaVector.length)
    }

    public Double apply(Double[] featureVector) {
        assert featureVector[0] == 1.0;
        double predection = 0.0
        // liner equation for predection
        // thetaVector[0]*1 + thetaVector[1] *  featureVector[1] + ...
        for (int i = 0 ; i < thetaVector.length ; i++) {
            predection += thetaVector[i] * featureVector[i];
        }
        return predection
    }
    
    public double[] getThetas() {
      return Arrays.copyOf(thetaVector, thetaVector.length);
    }
    
}

// (1/2m)*summation((predicted-label)^2)
def cost = {
    targetFunction, featureVectors->
        double sumSquaredErrors = 0;
        for (Double [] featureVector : featureVectors) {
            predictedPrice = targetFunction.apply(featureVector);
            //println "Predicted price " + predictedPrice 
            double label = featureVector[4]
            //println "Actual price " + label 
            double gap = predictedPrice - label;
            sumSquaredErrors += Math.pow(gap, 2); 
        }
        return sumSquaredErrors/(2*featureVectors.size());
}


// newThetaVector = thetaVector - learningRate * (1/m) * summation((perdicted-label)*featureVector)
def train = {
    targetFunction, featureVectors ,alpha ->
        Double[] existingThetas = targetFunction.getThetas();
        Double[] newThetaVector = new Double[existingThetas.length];
        int count = 0
        for (Double thetaVectorEle : existingThetas) {
            double sumErrors = 0;
            for (Double [] featureVector : featureVectors) {
                double gap = targetFunction.apply(featureVector) - featureVector[4];
                sumErrors += gap*featureVector[1]
            }
            double gradient = (1/featureVectors.size())*sumErrors;
            newThetaVector[count++] = thetaVectorEle - alpha*gradient
        }
        return new LinearRegressionTargetFunction(newThetaVector);
}

LinearRegressionTargetFunction targetFunction = new LinearRegressionTargetFunction(thetaVector);
double computedCost = cost(targetFunction,featureVectorList)
println "Initial Cost " + computedCost
println "Initial thetas "+ targetFunction.getThetas()
println "Initial predection " + targetFunction.apply(data)
println "Initial predection " + targetFunction.apply(data2)

def aplha = 0.0000001

// sampling
//for (Double[] theta : thetaVectorList) {
    //targetFunction = new LinearRegressionTargetFunction(theta);

for (int i = 0 ; i <1000; i++) {
    targetFunction = train(targetFunction, featureVectorList, aplha)
    //println cost(targetFunction,featureVectorList)    
}

for (Double[] feature : featureVectorList) {
    def price = targetFunction.apply(feature)
    println "Final predection on test data - ${price} with a gap ${feature[4] - price}"
}
println "Final Cost " + cost(targetFunction,featureVectorList)
println "Final thetas "+ targetFunction.getThetas()
println "Final predection " + targetFunction.apply(data)
println "Final predection " + targetFunction.apply(data2)

targetFunction = new LinearRegressionTargetFunction(thetaVector1);
println "Probable price " + targetFunction.apply(data)
println "Probable price " + targetFunction.apply(data2)