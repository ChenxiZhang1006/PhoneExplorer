cd bin/
jar -cvmf storeDataIntoFileManifest.mf ../storeDataIntoFile.jar storeDataIntoFile.class fileFunc.class dbConnect.class 
cd ..
java -jar storeDataIntoFile.jar dbData varDescs.txt dbData dbgap_indexer.txt