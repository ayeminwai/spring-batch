package com.v6team.amw.springbatch.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.DefaultBatchConfigurer;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.batch.item.json.JacksonJsonObjectReader;
import org.springframework.batch.item.json.JsonItemReader;
import org.springframework.batch.item.json.builder.JsonItemReaderBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.v6team.amw.springbatch.model.StockData;

@Configuration
@EnableBatchProcessing

public class SpringBatchConfig extends DefaultBatchConfigurer {
	@Bean
	public Job job(JobBuilderFactory jobBuilderFactory,
			StepBuilderFactory stepBuilderFactory,
			ItemReader<StockData> itemReader,
			JsonItemReader<StockData> jsonItemReader,
			ItemProcessor<StockData, StockData> itemProcessor,
			ItemWriter<StockData> itemWriter) {
		
		Step step1 = stepBuilderFactory.get("step1")
				.<StockData, StockData> chunk(3)
				.reader(itemReader)
				.processor(itemProcessor)
				.writer(itemWriter)
				.build();
		Step step2 = stepBuilderFactory.get("step2")
				.<StockData, StockData> chunk(3)
				.reader(jsonItemReader)
				.processor(itemProcessor)
				.writer(itemWriter)
				.build();
				
		return jobBuilderFactory.get("job")
		.incrementer(new RunIdIncrementer())
		.start(step1)
		.next(step2)
		.build();
	}
	
	@Bean
	public FlatFileItemReader<StockData> itemReader(@Value("${input}") Resource resource){
		FlatFileItemReader<StockData> flatFileItemReader = new FlatFileItemReader<>();
		flatFileItemReader.setResource(resource);
		flatFileItemReader.setName("CSV-Reader");
		flatFileItemReader.setLinesToSkip(1);
		flatFileItemReader.setLineMapper(lineMapper());
		return flatFileItemReader;
	}
	
	@Bean
	public JsonItemReader<StockData> jsonItemReader() {

	   ObjectMapper objectMapper = new ObjectMapper();
	   // configure the objectMapper as required

	   JacksonJsonObjectReader<StockData> jsonObjectReader = new JacksonJsonObjectReader<>(StockData.class);
	   jsonObjectReader.setMapper(objectMapper);
	   
	   //Resource resource = new FileSystemResource("resources/trades.csv");
	   return new JsonItemReaderBuilder<StockData>()
	                 .jsonObjectReader(jsonObjectReader)
	                 .resource(new ClassPathResource("stock.json"))
	                 .name("tradeJsonItemReader")
	                 .build();
	}

	public LineMapper<StockData> lineMapper() {
		DefaultLineMapper<StockData> defaultLineMapper = new DefaultLineMapper<>();
		DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
		
		lineTokenizer.setDelimiter(",");
		lineTokenizer.setStrict(false);
		lineTokenizer.setNames(new String[] {"id", "code", "name", "qty", "price"});
		
		BeanWrapperFieldSetMapper<StockData> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
		fieldSetMapper.setTargetType(StockData.class);
		
		defaultLineMapper.setLineTokenizer(lineTokenizer);
		defaultLineMapper.setFieldSetMapper(fieldSetMapper);
		return defaultLineMapper;
	}
}
