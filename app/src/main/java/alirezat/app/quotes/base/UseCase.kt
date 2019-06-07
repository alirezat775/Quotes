package alirezat.app.quotes.base

abstract class UseCase<Q : UseCase.RequestValue, R : UseCase.ResponseValue, E : UseCase.ErrorValue> {

    private lateinit var mUseCaseCallback: UseCaseCallback<R, E>

    fun getUseCaseCallback(): UseCaseCallback<R, E> {
        return mUseCaseCallback
    }

    fun setUseCaseCallback(useCaseCallback: UseCaseCallback<R, E>) {
        mUseCaseCallback = useCaseCallback
    }

    abstract fun executeUseCase(requestValue: RequestValue)

    fun run(requestValue: RequestValue) {
        executeUseCase(requestValue)
    }

    interface RequestValue

    interface ResponseValue

    interface ErrorValue

    interface UseCaseCallback<R, E> {

        fun success(responseValue: R)

        fun error(errorValue: E)
    }
}