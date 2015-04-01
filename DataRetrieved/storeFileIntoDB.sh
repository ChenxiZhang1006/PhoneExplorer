cd bin/
jar -cvmf storeFileIntoDBManifest.mf ../storeFileIntoDB.jar storeFileIntoDB.class fileFunc.class dbConnect.class 
cd ..
java -jar storeFileIntoDB.jar varDescExpansion dbData varDescs_expanded.txt