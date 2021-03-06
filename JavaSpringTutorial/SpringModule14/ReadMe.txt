#Spring Module 14 - Hibernate

#################################################################
Setting up Hibernate
#################################################################
Add these dependencies

		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-orm</artifactId>
			<version>4.3.3.RELEASE</version>
		</dependency>
		<dependency>
			<groupId>org.hibernate</groupId>
			<artifactId>hibernate-core</artifactId>
			<version>4.3.3.Final</version>
		</dependency>


Update sessionFactory in dao-context.xml and datasource.xml to look like the following

<bean id="sessionFactory"
			class="org.springframework.orm.hibernate4.LocalSessionFactoryBean">

			<property name="dataSource" ref="dataSource"></property>
			<property name="hibernateProperties">
				<props>
					<prop key="hibernate.dialect">org.hibernate.dialect.MySQL5Dialect</prop>
					<prop key="javax.persistence.validation.group.pre-persist">us.brianolsen.spring.web.dao.PersistenceValidationGroup
					</prop>
					<prop key="javax.persistence.validation.group.pre-update">us.brianolsen.spring.web.dao.PersistenceValidationGroup
					</prop>
					<prop key="javax.persistence.validation.group.pre-remove">us.brianolsen.spring.web.dao.PersistenceValidationGroup
					</prop>
				</props>
			</property>
			<property name="packagesToScan">
				<list>
					<value>us.brianolsen.spring.web.model</value>
				</list>
			</property>
		</bean>

add a transaction manager

		<bean id="transactionManager"
			class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
			<property name="dataSource" ref="dataSource"></property>
		</bean>
		<tx:annotation-driven />


add an exception tranlator and add javax annotations @Repository and @Transactional above the dao classes.

		<!-- acesses any dao marked as @Repository and translates internal query 
			exceptions to DataAccessExceptions -->
		<bean id="exceptionTranslator"
			class="org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor">
		</bean>
		
Above the model classes add javax annotations
@Entity and @Table(name = "<name-of-db-table-entity-maps-to>") 
