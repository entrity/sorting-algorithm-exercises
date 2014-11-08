load 'tree_sort_demo.rb'
load 'heap_sort_demo.rb'

# Function for executing an algorithm demo
def profile name
  num_array = @numbers_to_sort
  start = Time.now
  yield(num_array)
  finish = Time.now
  puts "%20s %20f" % [name, finish - start]
end

# Generate test data
@numbers_to_sort = 
if ARGV[0] && File.exist?(ARGV[0])
  puts "Reading test data"
  require 'json'
  JSON.parse File.read(ARGV[0])
else
  puts "Generating test data"
  (0..10000).map{ rand(5000) }
end

# Run 
profile('tree sort'){ |data| tree_sort(data) }
profile('heap sort'){ |data| heap_sort(data) }
