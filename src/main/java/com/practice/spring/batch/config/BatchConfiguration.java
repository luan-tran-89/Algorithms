package com.practice.spring.batch.config;

import org.springframework.context.annotation.Configuration;

/**
 * @author gasieugru
 */
@Configuration
public class BatchConfiguration {
//
//    @Value("${file.input}")
//    private String fileInput;
//
//    @Bean
//    public FlatFileItemReader render() {
//        return new FlatFileItemReaderBuilder().name("coffeeItemReader")
//                .resource(new ClassPathResource(fileInput))
//                .delimited()
//                .names(new String[] {"brand", "origin", "characteristics"})
//                .fieldSetMapper(new BeanWrapperFieldSetMapper() {{
//                    setTargetType(Coffee.class);
//                }})
//                .build();
//    }
//
//    @Bean
//    public JdbcBatchItemWriter writer(DataSource dataSource) {
//        return new JdbcBatchItemWriterBuilder()
//                .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
//                .sql("INSERT INTO coffee (brand, origin, characteristics) VALUES (:brand, :origin, :characteristics)")
//                .dataSource(dataSource)
//                .build();
//    }
//
//    @Bean
//    public Job importUserJob(JobRepository jobRepository, JobCompletionNotificationListener listener, Step step1) {
//        return new JobBuilder("importUserJob", jobRepository)
//                .incrementer(new RunIdIncrementer())
//                .listener(listener)
//                .flow(step1)
//                .end()
//                .build();
//    }
//
//    @Bean
//    public Step step1(JobRepository jobRepository, PlatformTransactionManager transactionManager, JdbcBatchItemWriter writer) {
//        return new StepBuilder("step1", jobRepository)
//                .<Coffee, Coffee> chunk(10, transactionManager)
//                .reader(render())
//                .processor(processor())
//                .writer(writer)
//                .build();
//    }
//
//    @Bean
//    public CoffeeItemProcessor processor() {
//        return new CoffeeItemProcessor();
//    }

}
