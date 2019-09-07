package NetworkUtils;

import android.net.ConnectivityManager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import Model.WrapperResponse;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WrapperConverterFactory extends Converter.Factory {
    private GsonConverterFactory gsonFactory;

    public WrapperConverterFactory(GsonConverterFactory factory){
        this.gsonFactory = factory;
    }

    @Override
    public Converter<ResponseBody, ?> responseBodyConverter
            (final Type type, Annotation[] annotations, Retrofit retrofit) {

        Type wrappedType = new ParameterizedType() {
            @NonNull
            @Override
            public Type[] getActualTypeArguments() {
                return new Type[]{type};
            }

            @NonNull
            @Override
            public Type getRawType() {
                return null;
            }

            @Nullable
            @Override
            public Type getOwnerType() {
                return WrapperResponse.class;
            }
        };
        Converter<ResponseBody, ?> gsonConverter = gsonFactory.responseBodyConverter
                (wrappedType,annotations,retrofit);

        return new WrapperConverterFactory(gsonConverter);
    }
}
