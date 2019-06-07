package alirezat.app.quotes.base

object UseCaseHandler {

    fun <Q : UseCase.RequestValue, R : UseCase.ResponseValue, E : UseCase.ErrorValue>
            execute(useCase: UseCase<Q, R, E>, values: Q, callback: UseCase.UseCaseCallback<R, E>) {
        useCase.setUseCaseCallback(callback)
        useCase.run(values)
    }
}