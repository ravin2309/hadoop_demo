# hadoop_demo
This hadoop project counts the number of odd and even per line and gives output with line number

# requirement 
you should have either hadoop 2.x 

# To Build
clone the repo and excute below commands

mvn clean instal

Before running the above make sure you are inside project folder, after running this comand you will have 
target folder inside which you will find your jar file, run the below command on hdfs and prior to that
move your dataset to hdfs 

 hadoop jar OddEven-0.0.1-SNAPSHOT.jar demo.hadoop.OddEven.OddEvenDriver /${input_file}/${file_name}  /${output_location_on_hdfs}

#Sample data

1,4,3,7,6,8549,234,642
2,8,9,1,7,6,9
4,3,5,9,7,8,2
5,3
4,5,7,2,4,3
54,7634,65,1,4,3,7,6,89
5,2,8,9,1,7,6,9
4,2,3,6,5,9,433,782,45,5,7,8,2
5,3,2,5,2,7,1,9,6,4,8,0
4,6,5,7,65,78,243,567,87


final output
line0 Even count: 4 Odd count: 4
line 1 Even count: 3 Odd count: 4
line 2 Even count: 3 Odd count: 5



